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
import com.raza.inventory.business.bean.MaterialTypeBean;
import com.raza.inventory.exceptions.MicroServiceException;

@Service
public class MaterialTypeConsumer {

	@Value("${material.service.url}")
	private String serviceURL;

	@Value("${material.type.api.url}")
	private String apiURL;

	@Value("${material.type.api.url.by-category-id}")
	private String apiURLByCategoryId;

	private RestTemplate restTemplate;

	private List<MaterialTypeBean> materialTypeBeanList;

	private Map<String, String> categoryTypeMap;
	private Map<String, String> categoryTypeMap1;

	public List<MaterialTypeBean> getMaterialTypeBeanList() throws MicroServiceException {
		return materialTypeBeanList;
	}

	public Map<String, String> getCategoryTypeMap() throws MicroServiceException {
		hitGetMaterialType();
		return categoryTypeMap;
	}

	public Map<String, String> getCategoryTypeMap1() throws MicroServiceException {

		return categoryTypeMap1;
	}

	public MaterialTypeConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material type.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialType() throws MicroServiceException {
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> materialType = restTemplate.getForObject(serviceURL + apiURL, List.class);
		ObjectMapper mapper = new ObjectMapper();
		materialTypeBeanList = new ArrayList<MaterialTypeBean>();
		categoryTypeMap = new HashMap<String, String>();
		if (materialType != null) {
			for (LinkedHashMap<String, Object> map : materialType) {
				// Map object should be converted to Employee type
				MaterialTypeBean type = mapper.convertValue(map, MaterialTypeBean.class);
				categoryTypeMap.put(type.getTypeId(), type.getTypeName());
				materialTypeBeanList.add(type);
			}
			System.out.println("Material types are: " + materialTypeBeanList);
		}
	}

	/**
	 * This method hits material microservice to get the details of Material type
	 * based on category id.
	 * 
	 * @param categoryId
	 * @return List<MaterialTypeBean>
	 * @throws MicroServiceException
	 */
	public Map<String, String> hitGetTypesBasedOnCategoryId(String categoryId) throws MicroServiceException {
		List<MaterialTypeBean> lst = new ArrayList<MaterialTypeBean>();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> typeMap = restTemplate
				.getForObject(serviceURL + apiURLByCategoryId + categoryId, List.class);
		ObjectMapper mapper = new ObjectMapper();
		lst = new ArrayList<MaterialTypeBean>();
		categoryTypeMap1 = new HashMap<String, String>();
		if (typeMap != null) {
			for (LinkedHashMap<String, Object> map : typeMap) {
				// Map object should be converted to Employee type
				MaterialTypeBean emp = mapper.convertValue(map, MaterialTypeBean.class);
				categoryTypeMap1.put(emp.getTypeId(), emp.getTypeName());
				lst.add(emp);
			}
			System.out.println("Category Type Map is " + categoryTypeMap1);
		}
		return categoryTypeMap1;
	}

}
