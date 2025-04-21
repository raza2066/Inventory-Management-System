package com.raza.material.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raza.material.entity.MaterialTypeEntity;

public interface MaterialTypeDao extends JpaRepository<MaterialTypeEntity, String>{
	
	@Query("SELECT m FROM MaterialTypeEntity m WHERE m.materialCategoryEntity.category_id = :category_id")
    List<MaterialTypeEntity> findByCategory_id(String category_id);

}
