package com.raza.inventory.web.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raza.inventory.business.bean.VendorBean;
import com.raza.inventory.exceptions.MicroServiceException;

@Service
public class VendorServiceConsumer {

	@Value("${vendor.service.url}")
	private String serviceURL;

	@Value("${vendor.api.url}")
	private String apiURL;

	private List<VendorBean> vendorBeanList;

	private Map<String, VendorBean> vendorMap;

	private RestTemplate restTemplate;

	public List<VendorBean> getVendorBeanList() throws MicroServiceException {
		hitGetVendorDetails();
		return vendorBeanList;
	}

	public Map<String, VendorBean> getVendorMap() {
		return vendorMap;
	}

	public VendorServiceConsumer() {
		restTemplate = new RestTemplate();

	}

	/**
	 * This method is hitting vendor microservice to get the list of vendors
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetVendorDetails() throws MicroServiceException {

		String url = serviceURL + apiURL;
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> res = restTemplate.getForObject(url, List.class);
		ObjectMapper mapper = new ObjectMapper();
		vendorBeanList = new ArrayList<VendorBean>();
		vendorMap = new HashMap<String, VendorBean>();
		if (res != null) {
			for (LinkedHashMap<String, Object> map : res) {
				// Map object should be converted to Employee type
				VendorBean vendor = mapper.convertValue(map, VendorBean.class);
				vendorMap.put(vendor.getVendorName(), vendor);

				vendorBeanList.add(vendor);
			}
			System.out.println(vendorBeanList);
		}

	}
}
