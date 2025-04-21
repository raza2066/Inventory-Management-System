package com.raza.inventory.dao;

import com.raza.inventory.entity.PurchaseEntity;

public interface PurchaseDao {
	public PurchaseEntity savePurchaseDetails(PurchaseEntity entity) throws Exception;
}
