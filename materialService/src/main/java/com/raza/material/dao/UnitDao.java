package com.raza.material.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raza.material.entity.UnitEntity;

public interface UnitDao extends JpaRepository<UnitEntity, String>{

	@Query("SELECT m FROM UnitEntity m WHERE m.materialCategoryEntity.category_id = :category_id")
    List<UnitEntity> findByCategory_id(String category_id);

}
