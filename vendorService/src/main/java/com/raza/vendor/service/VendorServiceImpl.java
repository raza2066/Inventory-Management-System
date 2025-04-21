package com.raza.vendor.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.vendor.bean.VendorBean;
import com.raza.vendor.dao.VendorDAO;
import com.raza.vendor.entity.VendorEntity;

@Service
public class VendorServiceImpl implements VendorService{

	
	@Autowired
	private VendorDAO venderDao;

	@Override
	public List<VendorBean> getVendorDetails() {
		List<VendorBean> beans = null;
		
		List<VendorEntity> entities = venderDao.findAll();
		if(entities!=null) {
			beans = new ArrayList<VendorBean>();
			for(VendorEntity entity:entities) {
				VendorBean bean = new VendorBean();
				BeanUtils.copyProperties(entity, bean);
				beans.add(bean);
			}
		}
		
		return beans;
	}
	
}
