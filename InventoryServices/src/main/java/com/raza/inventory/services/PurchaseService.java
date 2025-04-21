package com.raza.inventory.services;

import com.raza.inventory.business.bean.PurchaseBean;

public interface PurchaseService {
	PurchaseBean addPurchaseDetails(PurchaseBean purchaseBean) throws Exception;
}
