package com.inventory.service;

import com.inventory.entity.ProductPojo;

public interface ProductService {
	public Iterable<ProductPojo> getAll();

	public ProductPojo createProduct(ProductPojo product);

	public void remove(Long id);

	public ProductPojo getByID(Long id);

	public ProductPojo update(ProductPojo product);
}
