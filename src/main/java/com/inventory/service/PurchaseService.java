package com.inventory.service;

import com.inventory.entity.PurchasePojo;

public interface PurchaseService {

	PurchasePojo save(PurchasePojo purchase);

	Iterable<PurchasePojo> get();

	PurchasePojo getById(Long id);

	PurchasePojo update(PurchasePojo purchase);

	void delete(Long id);

}
