package com.raza.inventory.web.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.raza.inventory.business.bean.MaterialCategoryBean;
import com.raza.inventory.business.bean.PurchaseBean;
import com.raza.inventory.business.bean.VendorBean;
import com.raza.inventory.exceptions.MicroServiceException;
import com.raza.inventory.services.PurchaseService;
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
@SessionAttributes({ "purchaseBean","typemap","typeunit" })
public class PurchaseEntryController {

	@Autowired 
	PurchaseService purchaseService;
	// Auto wire PurchaseService here
	@Autowired
	VendorServiceConsumer vendorServiceConsumer;
	// Auto wire VendorServiceConsumer here
	@Autowired
	MaterialCategoryConsumer materialCategoryConsumer;
	// Auto wire MaterialCategoryConsumer here
	@Autowired
	UnitServiceConsumer unitServiceConsumer;
	// Auto wire UnitServiceConsumer here
	@Autowired
	MaterialTypeConsumer materialTypeConsumer;

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method sets PurchaseBean into the model attribute and redirects to
	 * PurchaseEntry.jsp.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "purchaseEntry.html", method = RequestMethod.GET)
	public ModelAndView purchaseEntry() throws Exception {
		PurchaseBean purchaseBean = new PurchaseBean();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseEntry");
		modelAndView.addObject("purchaseBean", purchaseBean);
		return modelAndView;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the vendor list to be populated on the
	 * PurchasEntry.jsp. getVendorBeanList method of VendorServiceConsumer is
	 * called to get the vendor list.
	 * 
	 * @return vendorList - List of vendor values
	 * @throws MicroServiceException
	 */
	@ModelAttribute("vendorList")
	public List<String> generateVendorList() throws MicroServiceException {
		List<VendorBean> lstBean=vendorServiceConsumer.getVendorBeanList();
		List<String> lst = new ArrayList<String>();
		for(VendorBean it: lstBean) {
			lst.add(it.getVendorName());
		}
		return lst;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material unit and type list to be populated in
	 * PurchaseEntry.jsp for chosen material category. hitGetUnitsByCategoryId
	 * method of UnitServiceConsumer class to be called to get the list of
	 * material unit. hitGetTypesBasedOnCategoryId method of
	 * MaterialTypeConsumer class to be called to get the list of material type.
	 * 
	 * @param purchaseBean
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws MicroServiceException
	 */
	@RequestMapping(value = "getUnitAndTypeList.html", method = RequestMethod.POST)
	public ModelAndView generateUnitAndTypeList(@ModelAttribute("purchaseBean") PurchaseBean purchaseBean,
			HttpSession session) throws MicroServiceException {
		
		Map<String, String> mp=null;
		mp=materialTypeConsumer.hitGetTypesBasedOnCategoryId(purchaseBean.getMaterial_category_id());
		Map<String, String> mp1= null;
		mp1= unitServiceConsumer.hitGetUnitsByCategoryId(purchaseBean.getMaterial_category_id());
		
		MaterialCategoryBean mBean=materialCategoryConsumer.hitGetMaterialCategoryById(purchaseBean.getMaterial_category_id());
		purchaseBean.setMaterialCategoryNameString(mBean.getCategoryName());
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseEntry");
		modelAndView.addObject("typemap", mp);
		modelAndView.addObject("IsVisible","yes");
		modelAndView.addObject("typeunit", mp1);
		return modelAndView;
	
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material category list to be populated on the
	 * PurchasEntry.jsp. getMaterialCategoryBeanList method of
	 * MaterialCategoryConsumer is called to get the material category list.
	 * 
	 * @return List - MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	@ModelAttribute("categoryList")
	public Map<String, String> generateCategoryList() throws MicroServiceException {
		return materialCategoryConsumer.getCategoryMap();
	}
	

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to insert purchase details filled on
	 * PurchaseEntry.jsp in to the purchase and payment table. Upon successful
	 * insert redirects to PurchaseSuccess.jsp
	 * 
	 * @param purchaseBean
	 * @param BindingResult
	 * @param ModelMap
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "addPurchaseDetail.html", method = RequestMethod.POST)
	public ModelAndView addPurchaseDetail(@ModelAttribute("purchaseBean") @Valid PurchaseBean purchaseBean,
			BindingResult bindingResult, ModelMap map, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(bindingResult.hasErrors())
		{
			System.out.println(purchaseBean.toString());
			modelAndView.setViewName("PurchaseEntry");
			modelAndView.addObject("IsVisible","yes");
		}
		else{
			System.out.println("Purchase Bean in Controller is:"+purchaseBean);
			@SuppressWarnings("unused")
			PurchaseBean bean= purchaseService.addPurchaseDetails(purchaseBean);
			modelAndView.setViewName("PurchaseSuccess");
		}
		return modelAndView;
	}

}