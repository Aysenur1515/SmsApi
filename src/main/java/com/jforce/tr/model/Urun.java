package com.jforce.tr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urun")
public class Urun implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Column(name = "urun_isim")
	private String urunIsmi;
	
	@Column(name = "urun_fiyat")
	private float urunFiyat;
	
	@Column(name = "miktar")
	private int miktar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrunIsmi() {
		return urunIsmi;
	}

	public void setUrunIsmi(String urunIsmi) {
		this.urunIsmi = urunIsmi;
	}

	public float getUrunFiyat() {
		return urunFiyat;
	}

	public void setUrunFiyat(float urunFiyat) {
		this.urunFiyat = urunFiyat;
	}

	public int getMiktar() {
		return miktar;
	}

	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}

	@Override
	public String toString() {
		return "Urun [id=" + id + ", urunIsmi=" + urunIsmi + ", urunFiyat=" + urunFiyat + ", miktar=" + miktar + "]";
	}
	
	
}
