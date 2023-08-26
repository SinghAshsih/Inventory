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

import com.inventory.entity.PurchasePojo;
import com.inventory.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	PurchaseService purchaseService;

	@PostMapping
	public PurchasePojo save(@RequestBody PurchasePojo purchase) {
		return purchaseService.save(purchase);

	}

	@GetMapping
	public Iterable<PurchasePojo> get() {
		return purchaseService.get();

	}

	@GetMapping("/{id}")

	public PurchasePojo getById(@PathVariable Long id) {
		return purchaseService.getById(id);
	}

	@PutMapping
	public PurchasePojo update(@RequestBody PurchasePojo purchase) {
		return purchaseService.update(purchase);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		purchaseService.delete(id);
		return "Delete Successfully";
	}
}
