package com.inventory.service;

import com.inventory.entity.CategoryPojo;

public interface CategoryService {

	public Iterable<CategoryPojo> getAll();

	public CategoryPojo getById(Long id);

	public CategoryPojo Save(CategoryPojo category);

	public CategoryPojo update(CategoryPojo category);

	public void remove(Long id);

}
