package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.SupplierPojo;
import com.inventory.repository.SupplierRepo;
import com.inventory.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	SupplierRepo supplierRepo;

	@Override
	public SupplierPojo save(SupplierPojo supplier) {

		return supplierRepo.save(supplier);
	}

	@Override
	public Iterable<SupplierPojo> get() {
		Iterable<SupplierPojo> supplier;
		supplier = supplierRepo.findAll();
		return supplier;
	}

	@Override
	public SupplierPojo getById(Long id) {
		Optional<SupplierPojo> supplier = supplierRepo.findById(id);
		return supplier.get();
	}

	@Override
	public SupplierPojo update(SupplierPojo supplier) {

		return supplierRepo.save(supplier);
	}

	@Override
	public void delete(Long id) {
		supplierRepo.deleteById(id);

	}

}
