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

import com.inventory.entity.SalesPojo;
import com.inventory.service.SalesService;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {
	@Autowired
	SalesService salesService;

	@PostMapping
	public SalesPojo save(@RequestBody SalesPojo sales) {
		return salesService.save(sales);
	}

	@GetMapping
	public Iterable<SalesPojo> findAll() {
		return salesService.findAll();
	}

	@PutMapping
	public SalesPojo update(@RequestBody SalesPojo sales) {
		return salesService.update(sales);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		salesService.delete(id);
		return "Delete Sussesfully";
	}

	@GetMapping("/{id}")
	public SalesPojo findById(@PathVariable Long id) {
		return salesService.findById(id);
	}
}
