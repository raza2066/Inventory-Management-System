package com.raza.inventory.services;

import java.util.Date;
import java.util.List;

import com.raza.inventory.business.bean.PurchaseBean;

public interface ReportsService {
	List<PurchaseBean> getVendorPurchaseDetails(String vendor_name, Date fromDate, Date toDate);
}
