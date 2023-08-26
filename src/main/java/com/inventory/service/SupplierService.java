package com.inventory.service;

import com.inventory.entity.SupplierPojo;

public interface SupplierService {

	SupplierPojo save(SupplierPojo supplier);

	Iterable<SupplierPojo> get();

	SupplierPojo getById(Long id);

	SupplierPojo update(SupplierPojo supplier);

	void delete(Long id);

}
