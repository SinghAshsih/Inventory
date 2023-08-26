package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.ProductPojo;

public interface ProductRepo extends CrudRepository<ProductPojo, Long> {

}
