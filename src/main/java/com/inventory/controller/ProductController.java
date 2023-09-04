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

import com.inventory.entity.ProductPojo;
import com.inventory.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/{id}")
	public ProductPojo getById(@PathVariable Long id) {
		return productService.getByID(id);
	}

	@GetMapping
	public Iterable<ProductPojo> getAll() {
		return productService.getAll();
	}

	@PostMapping
	public ProductPojo createProduct(@RequestBody ProductPojo product) {
		return productService.createProduct(product);
	}

	@PutMapping
	public ProductPojo update(@RequestBody ProductPojo product) {
		return productService.update(product);

	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		productService.remove(id);

		return "Record delete successfully";
	}
}
