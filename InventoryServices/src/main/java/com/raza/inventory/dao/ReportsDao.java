package com.raza.inventory.dao;

import java.util.Date;
import java.util.List;

import com.raza.inventory.business.bean.PurchaseBean;

public interface ReportsDao {
	public List<PurchaseBean> getVendorPurchaseDetails(String vendor_name, Date fromDate, Date toDate);
}
