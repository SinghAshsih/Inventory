package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.PurchasePojo;

public interface PurchaseRepo extends CrudRepository<PurchasePojo, Long> {

}
