package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.SupplierPojo;
import com.inventory.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	SupplierService supplierService;

	@PostMapping
	public SupplierPojo save(@RequestBody SupplierPojo supplier) {
		return supplierService.save(supplier);
	}

	@GetMapping
	public Iterable<SupplierPojo> get() {
		return supplierService.get();
	}

	@GetMapping("/{id}")
	public SupplierPojo getById(@PathVariable Long id) {
		return supplierService.getById(id);
	}

	@PutMapping
	public SupplierPojo update(@RequestBody SupplierPojo supplier) {
		return supplierService.update(supplier);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		supplierService.delete(id);
		return "Delete Successfully:";

	}

}
