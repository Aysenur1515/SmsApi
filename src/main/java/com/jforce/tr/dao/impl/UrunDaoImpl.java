package com.jforce.tr.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jforce.tr.dao.UrunDao;
import com.jforce.tr.model.Musteri;
import com.jforce.tr.model.Stok;
import com.jforce.tr.model.Urun;

@Repository
public class UrunDaoImpl implements UrunDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Urun> getUrunList() {
		List<Urun> urunList = null;
		try {
			urunList = entityManager.createQuery("from Urun", Urun.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata olustu : " + e.getMessage());
		}
		return urunList;
	}

	@Override
	@Transactional
	public void update(Integer id, int kilo) {
		try {
			entityManager.createNativeQuery("update urun set miktar=miktar-:kilo where id=:id")
			.setParameter("kilo", kilo)
			.setParameter("id", id)
			.executeUpdate();
		} catch (Exception e) {
			System.out.println("Ürün update edilirken hata olustu : " + e.getMessage());
		}
	}

	@Override
	public Urun getUrunById(Integer id) {
		Urun urun=null;
		try {
			urun =  entityManager.createQuery("from Urun where id=:id", Urun.class)
					.setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			System.out.println("Ürün getirilirken hata olustu : "  + e.getMessage());
		}
		return urun;
	}

	@Override
	public Stok getStok() {
		return entityManager.createQuery("from Stok", Stok.class).getSingleResult();
	}

	@Override
	public List<Musteri> getMusteriList() {
		List<Musteri> musteriList=null;
		try {
			musteriList = entityManager.createQuery("from Musteri", Musteri.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata olustu : " + e.getMessage());
		}
		return musteriList;
	}

}
