package com.raza.inventory.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raza.inventory.entity.PurchaseEntity;

import jakarta.persistence.EntityManager;

@Repository
@Transactional(value = "txmanager")
public class PurchaseDaoImpl implements PurchaseDao{
	@Autowired
	EntityManager entityManager;
	
	@Override
	public PurchaseEntity savePurchaseDetails(PurchaseEntity entity) throws Exception {
		
		try {
			entityManager.persist(entity);			
		} catch (Exception exception) {
			throw exception;
		}
		return entity;
	}

}
