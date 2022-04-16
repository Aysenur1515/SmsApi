package com.jforce.tr.sqluygulama;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jforce.tr.dao.UrunDao;
import com.jforce.tr.jsonbase.JsonWebServiceClientBase;
import com.jforce.tr.model.Authentication;
import com.jforce.tr.model.Musteri;
import com.jforce.tr.model.Order;
import com.jforce.tr.model.Receipents;
import com.jforce.tr.model.Request;
import com.jforce.tr.model.SendSMSRequest;
import com.jforce.tr.model.Stok;
import com.jforce.tr.model.Urun;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource.Builder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT , classes = SqlUygulamaApplication.class)
public class SqlUygulamaApplicationTests extends JsonWebServiceClientBase{

	
	@Autowired
	private UrunDao urunDaoImpl;
	

	
	
	@Test
	public void gonder()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Mail gönderme uygulamasına hoşgeldin!");
		System.out.println("------------------------------------");
		List<Musteri> musteriList = urunDaoImpl.getMusteriList();
		System.out.println("İd \t İsim \t Soyisim \t Telefon No");
		for (Musteri musteri : musteriList) {
			System.out.println(musteri.getId() +" \t" + musteri.getIsim() + " \t" + musteri.getSoyisim() +" \t \t" + musteri.getTelno());
		}
		System.out.println("-----------------------------------------------");
		System.out.print("SMS göndermek istediğiniz id değerini giriniz : ");
		int id = scanner.nextInt();
		
		
		String gonderilecekTelNo = null;
		for (Musteri musteri : musteriList) {
			if(musteri.getId().equals(id)) {
				gonderilecekTelNo = musteri.getTelno();
			}
		}
		sendSMS(gonderilecekTelNo);
	}

	static int SERVICE_TIMEOUT=10000000;
	public void sendSMS(String number) {
		
		String endPoint="https://api.iletimerkezi.com/v1/send-sms/json";
		ClientResponse clientResponse;
		
		SendSMSRequest sendSMSRequest = new SendSMSRequest();
		
		Receipents receipents = new Receipents();
		String[] alici = {number};
		receipents.setNumber(alici);
		
		com.jforce.tr.model.Message message = new com.jforce.tr.model.Message("test içerik", receipents);
		
		Order order  = new Order();
		order.setSender("APITEST");
		order.setIys(0);
		order.setIysList("BIREYSEL");
		order.setMessage(message);
		
		Request request = new Request();
		Authentication authentication = new Authentication("5f9a26808358b1b41dfa393d9d9bd6c1", "3f23aa655c8a93f1c45f06d1ee3a7c7ad6eb754db5d59ec443e7221163902995");
		request.setAuthentication(authentication);
		request.setOrder(order);
		
		sendSMSRequest.setRequest(request);
		
		try {
			Client client = new Client();
			client.setReadTimeout(SERVICE_TIMEOUT);
			client.setConnectTimeout(SERVICE_TIMEOUT);
		 	Builder webResource = client.resource(endPoint).header("Content-Type", "application/json");
		 	String jsonRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sendSMSRequest);
		 	JSONObject jsonRequestObject = new JSONObject(jsonRequest);
		 	
		 	clientResponse = webResource.type("application/json").post(ClientResponse.class,jsonRequestObject.toString());
		 	String responseString = clientResponse.getEntity(String.class);
		 	if(responseString.contains("200")) {
		 		System.out.println("SMS gönderildi.");
		 	}
		} catch (Exception e) {
			System.out.println("Hata olustu : " + e.getMessage());
		}
		
	}
	
	
}
