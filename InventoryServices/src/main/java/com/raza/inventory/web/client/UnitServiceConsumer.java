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
import com.raza.inventory.business.bean.UnitBean;
import com.raza.inventory.exceptions.MicroServiceException;

@Service
public class UnitServiceConsumer {

	@Value("${material.service.url}")
	private String serviceURL;

	@Value("${unit.api.url}")
	private String apiURL;

	@Value("${unit.api.url.by-category-id}")
	private String apiURLByCategoryId;

	private List<UnitBean> unitBeanList;

	private Map<String, String> unitMap;
	private Map<String, String> unitMap1;
	private RestTemplate restTemplate;

	public List<UnitBean> getUnitBeanList() throws MicroServiceException {
		return unitBeanList;
	}

	public Map<String, String> getUnitMap() throws MicroServiceException {
		hitGetUnitDetails();
		return unitMap;
	}

	public UnitServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of unit.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetUnitDetails() throws MicroServiceException {
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> unit=restTemplate.getForObject(serviceURL+apiURL, List.class);
		ObjectMapper mapper = new ObjectMapper();
		unitBeanList = new ArrayList<UnitBean>();
		unitMap= new HashMap<String, String>();
		if (unit != null) {
			for (LinkedHashMap<String, Object> map : unit) {
				//Map object should be converted to Employee type 
				UnitBean type=mapper.convertValue(map, UnitBean.class);
				unitMap.put(type.getUnitId(), type.getUnitName());
				unitBeanList.add(type);
			}
			System.out.println("Units are: "+unitBeanList);
		} 
	}

	/**
	 * This method hits material microservice to get the list of unit available for
	 * a given category id.
	 * 
	 * @param categoryId
	 * @return List<UnitBean>
	 * @throws MicroServiceException
	 */
	public Map<String, String> hitGetUnitsByCategoryId(String categoryId) throws MicroServiceException {
		List<UnitBean> lst = new ArrayList<UnitBean>();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> typeMap = restTemplate
				.getForObject(serviceURL + apiURLByCategoryId + categoryId, List.class);
		ObjectMapper mapper = new ObjectMapper();
		lst = new ArrayList<UnitBean>();
		unitMap1 = new HashMap<String, String>();
		if (typeMap != null) {
			for (LinkedHashMap<String, Object> map : typeMap) {
				// Map object should be converted to Employee type
				UnitBean emp = mapper.convertValue(map, UnitBean.class);
				lst.add(emp);
				unitMap1.put(emp.getUnitId(), emp.getUnitName());
			}
		}
		System.out.println("unit Map is: " + unitMap1);
		return unitMap1;
	}

}
