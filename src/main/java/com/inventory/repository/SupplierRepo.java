package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.SupplierPojo;

public interface SupplierRepo extends CrudRepository<SupplierPojo, Long> {

}
