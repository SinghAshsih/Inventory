package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.ProductPojo;
import com.inventory.repository.CategoryRepo;
import com.inventory.repository.ProductRepo;
import com.inventory.repository.PurchaseRepo;
import com.inventory.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ProductRepo productRepo;
	@Autowired
	PurchaseRepo purchaseRepo;

	@Override
	public Iterable<ProductPojo> getAll() {
		Iterable<ProductPojo> products;
		products = productRepo.findAll();
		return products;
	}

	@Override
	public ProductPojo createProduct(ProductPojo product) {

		return productRepo.save(product);
	}

	@Override
	public ProductPojo update(ProductPojo product) {
		return productRepo.save(product);
	}

	@Override
	public void remove(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public ProductPojo getByID(Long id) {
		Optional<ProductPojo> pro = productRepo.findById(id);
		return pro.get();

	}
}
