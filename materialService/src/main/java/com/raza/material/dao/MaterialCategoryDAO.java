package com.raza.material.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raza.material.entity.MaterialCategoryEntity;

public interface MaterialCategoryDAO extends JpaRepository<MaterialCategoryEntity, String>{

}
