package com.raza.inventory.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raza.inventory.business.bean.PurchaseBean;
import com.raza.inventory.entity.PurchaseEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional(value = "txmanager")
public class ReportsDaoImpl implements ReportsDao{
	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseBean> getVendorPurchaseDetails(String vendor_name, Date fromDate, Date toDate) {
		String querry = "select m from PurchaseEntity m wherem.vendor_name = ?1";
		
		if(fromDate != null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
			String from = sdf1.format(fromDate);
			querry = querry.concat(" and m.purchase_date >= '"+from+"'");
		}
		if(toDate != null) {
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
			String to = sdf1.format(toDate);
			querry = querry.concat(" and m.purchase_date >= '"+to+"'");
		}
		Query finalquerry = entityManager.createQuery(querry);
		finalquerry.setParameter(1, vendor_name);
		List<PurchaseEntity> resultSet = finalquerry.getResultList();
		List<PurchaseBean> vendorWisePurchaseBeanList = new ArrayList<PurchaseBean>();
		
		for(PurchaseEntity row:resultSet) {
			PurchaseBean bean = new PurchaseBean();
			System.out.println("row is "+row);
			bean.setBrandname(row.getBrandname());
			bean.setMaterial_category_id(row.getMaterial_category_id());
			bean.setMaterial_type_id(row.getMaterial_type_id());
			bean.setUnit_id(row.getUnit_id());
			bean.setPurchase_amount(row.getPurchase_amount());
			bean.setPurchase_date(row.getPurchase_date());
			bean.setQuantity(row.getQuantity());
			vendorWisePurchaseBeanList.add(bean);
		}
		
		return vendorWisePurchaseBeanList;
	}

}
