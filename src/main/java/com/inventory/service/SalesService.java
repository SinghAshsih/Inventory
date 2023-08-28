package com.inventory.service;

import com.inventory.entity.SalesPojo;

public interface SalesService {

	SalesPojo save(SalesPojo sales);

	Iterable<SalesPojo> findAll();

	SalesPojo update(SalesPojo sales);

	void delete(Long id);

	SalesPojo findById(Long id);

}
