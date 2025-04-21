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
import com.raza.inventory.business.bean.MaterialCategoryBean;
import com.raza.inventory.exceptions.MicroServiceException;

@Service
public class MaterialCategoryConsumer {

	@Value("${material.service.url}")
	private String serviceURL;
	@Value("${material.category.api.url}")
	private String apiURL;
	@Value("${material.category.api.url.by-id}")
	private String apiURLForById;
	private RestTemplate restTemplate;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private Map<String, String> categoryMap;

	public Map<String, String> getCategoryMap() throws MicroServiceException {
		hitGetMaterialCategories();
		return categoryMap;
	}

	public List<MaterialCategoryBean> getMaterialCategoryBeanList() throws MicroServiceException {
		return materialCategoryBeanList;
	}

	public MaterialCategoryConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material category.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialCategories() throws MicroServiceException {
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> category = restTemplate.getForObject(serviceURL + apiURL, List.class);
		ObjectMapper mapper = new ObjectMapper();
		materialCategoryBeanList = new ArrayList<MaterialCategoryBean>();
		categoryMap = new HashMap<String, String>();

		if (category != null) {
			for (LinkedHashMap<String, Object> map : category) {
				// Map object should be converted to Employee type
				MaterialCategoryBean materialCategoryBean = mapper.convertValue(map, MaterialCategoryBean.class);
				materialCategoryBeanList.add(materialCategoryBean);
				categoryMap.put(materialCategoryBean.getCategoryId(), materialCategoryBean.getCategoryName());
			}
		}
	}

	/**
	 * This method hits material microservice to get the details of Material
	 * category for given category id.
	 * 
	 * @param categoryId
	 * @return MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	public MaterialCategoryBean hitGetMaterialCategoryById(String categoryId) throws MicroServiceException {

		MaterialCategoryBean bean = restTemplate.getForObject(serviceURL + "/" + apiURLForById + categoryId,
				MaterialCategoryBean.class);
		return bean;
	}

}