package com.jforce.tr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "musteri")
public class Musteri {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "isim")
	private String isim;
	
	@Column(name = "soyisim")
	private String soyisim;
	
	@Column(name = "yas")
	private int yas;
	
	@Column(name = "telno")
	private String telno;
	
	@Column(name = "maas")
	private float maas;
	
	@Column(name = "dogumtarih")
	@Temporal(TemporalType.DATE)
	private Date dogumTarih;
	
	@Column(name = "olusturulmatarih")
	@Temporal(TemporalType.TIMESTAMP)
	private Date olusturmaTarih;
	
	public Musteri() {

	}

	public Musteri(Integer id, String isim, String soyisim, int yas, String telno, float maas, Date dogumTarih,
			Date olusturmaTarih) {
		this.id = id;
		this.isim = isim;
		this.soyisim = soyisim;
		this.yas = yas;
		this.telno = telno;
		this.maas = maas;
		this.dogumTarih = dogumTarih;
		this.olusturmaTarih = olusturmaTarih;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public float getMaas() {
		return maas;
	}

	public void setMaas(float maas) {
		this.maas = maas;
	}

	public Date getDogumTarih() {
		return dogumTarih;
	}

	public void setDogumTarih(Date dogumTarih) {
		this.dogumTarih = dogumTarih;
	}

	public Date getOlusturmaTarih() {
		return olusturmaTarih;
	}

	public void setOlusturmaTarih(Date olusturmaTarih) {
		this.olusturmaTarih = olusturmaTarih;
	}
	
}
