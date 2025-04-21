package com.raza.inventory.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.inventory.business.bean.PurchaseBean;
import com.raza.inventory.dao.ReportsDao;

@Service
public class ReportsServiceImpl implements ReportsService{
	
	@Autowired
	ReportsDao reportsDao;

	@Override
	public List<PurchaseBean> getVendorPurchaseDetails(String vendor_name, Date fromDate, Date toDate) {
		return reportsDao.getVendorPurchaseDetails(vendor_name, fromDate, toDate);
	}
	
}
