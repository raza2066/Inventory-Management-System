package com.raza.vendor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raza.vendor.entity.VendorEntity;

@Repository
public interface VendorDAO extends JpaRepository<VendorEntity, String>{

}
