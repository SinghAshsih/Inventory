package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.SalesPojo;

public interface SalesRepo extends CrudRepository<SalesPojo, Long> {

}
