package com.raza.inventory.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.inventory.business.bean.PurchaseBean;
import com.raza.inventory.dao.PurchaseDao;
import com.raza.inventory.entity.PurchaseEntity;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	PurchaseDao purchaseDao;

	@Override
	public PurchaseBean addPurchaseDetails(PurchaseBean purchaseBean) throws Exception {
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		
		BeanUtils.copyProperties(purchaseBean, purchaseEntity);
		
		String TxnId = transactionIdgenerator(purchaseBean.getVendor_name(), purchaseBean.getMaterialCategoryNameString(), purchaseBean.getPurchase_date());
		purchaseEntity.setTransaction_id(TxnId);
		PurchaseBean bean = new PurchaseBean();
		BeanUtils.copyProperties(purchaseDao.savePurchaseDetails(purchaseEntity), bean);
		
		return bean;
	}
	
	private String transactionIdgenerator(String vendorName, String materialCategoryname, Date purchaseDate) {
		String date = dateFormatChange(purchaseDate);
		String id = "p_"+vendorName.substring(0,3)+"_"+date+"_"+materialCategoryname.substring(0, 3);
		return id;
	}
	public String dateFormatChange(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String date1 = df.format(date);
		return date1;
	}

}
