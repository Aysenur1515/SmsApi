package com.jforce.tr.dao;

import java.util.List;

import com.jforce.tr.model.Musteri;
import com.jforce.tr.model.Stok;
import com.jforce.tr.model.Urun;

public interface UrunDao {

	public List<Urun> getUrunList();
	
	public Urun getUrunById(Integer id);
	
	public Stok getStok();
	
	public void update(Integer id, int kilo);
	
	public List<Musteri> getMusteriList();
	
	
}
