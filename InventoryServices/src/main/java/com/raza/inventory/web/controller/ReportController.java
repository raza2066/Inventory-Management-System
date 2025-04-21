package com.raza.inventory.web.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.raza.inventory.business.bean.PurchaseBean;
import com.raza.inventory.business.bean.VendorBean;
import com.raza.inventory.business.bean.VendorPurchaseReport;
import com.raza.inventory.exceptions.MicroServiceException;
import com.raza.inventory.services.ReportsService;
import com.raza.inventory.web.client.MaterialCategoryConsumer;
import com.raza.inventory.web.client.MaterialTypeConsumer;
import com.raza.inventory.web.client.UnitServiceConsumer;
import com.raza.inventory.web.client.VendorServiceConsumer;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * A controller class for receiving and handling all material purchase related
 * transactions from the User Interface. <br/>
 *
 */
@Controller
public class ReportController {

	
	@Autowired 
	ReportsService reportService;
	
	@Autowired
	VendorServiceConsumer vendorServiceConsumer;
	
	@Autowired
	MaterialCategoryConsumer materialCategoryConsumer;
	// Auto wire MaterialCategoryConsumer here
	@Autowired
	UnitServiceConsumer unitServiceConsumer;
	// Auto wire UnitServiceConsumer here
	@Autowired
	MaterialTypeConsumer materialTypeConsumer;
	
	@Autowired
	VendorServiceConsumer VendorServiceConsumer;
	
	
	@RequestMapping(value = "report.html", method = RequestMethod.GET)
	public ModelAndView report() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("report");
		modelAndView.addObject("vendorPurchaseReport", new VendorPurchaseReport());
		return modelAndView;
	}
	@ModelAttribute("vendorList")
	public List<String> generateVendorList() throws MicroServiceException {
		List<VendorBean> lstBean=vendorServiceConsumer.getVendorBeanList();
		List<String> lst = new ArrayList<String>();
		for(VendorBean it: lstBean) {
			lst.add(it.getVendorName());
		}
		return lst;
		
	}
	@RequestMapping(value = "getVendorWisePurchaseDetail.html", method = RequestMethod.POST)
	public ModelAndView getVendorPurchaseDetail(
			@ModelAttribute("vendorPurchaseReport") @Valid VendorPurchaseReport vendorPurchaseReport,
			BindingResult result, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<PurchaseBean> bean= reportService.getVendorPurchaseDetails(vendorPurchaseReport.getVendor_name(), vendorPurchaseReport.getFromDate(), vendorPurchaseReport.getToDate());
		System.out.println("bean for report is "+ bean);
		if(bean!= null && bean.size()>0) {
			Map<String, String> catMap = materialCategoryConsumer.getCategoryMap();
			Map<String, String> typeMap = materialTypeConsumer.getCategoryTypeMap();
			Map<String, String> unitMap= unitServiceConsumer.getUnitMap();
			for(PurchaseBean it: bean) {
				it.setMaterialCategoryNameString(catMap.get(it.getMaterial_category_id()));
				it.setMaterialTypeName(typeMap.get(it.getMaterial_type_id()));
				it.setMaterialUnitName(unitMap.get(it.getUnit_id()));
			}
		}
		if(result.hasErrors()) {
			modelAndView.setViewName("error");
		}
		else {
			modelAndView.setViewName("report");
			modelAndView.addObject("ListofPurchaseBean", bean);
			Map<String, VendorBean> vendorListMap=VendorServiceConsumer.getVendorMap();
			modelAndView.addObject("vendorBean", vendorListMap.get(vendorPurchaseReport.getVendor_name()));
		
			
		}
		return modelAndView;
	
	}

	

}