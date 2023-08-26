package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.CategoryPojo;
import com.inventory.repository.CategoryRepo;
import com.inventory.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public Iterable<CategoryPojo> getAll() {
		Iterable<CategoryPojo> category;
		category = categoryRepo.findAll();
		return category;
	}

	@Override
	public CategoryPojo getById(Long id) {
		Optional<CategoryPojo> category = categoryRepo.findById(id);
		return category.get();
	}

	@Override
	public CategoryPojo Save(CategoryPojo category) {

		return categoryRepo.save(category);
	}

	@Override
	public CategoryPojo update(CategoryPojo category) {

		return categoryRepo.save(category);
	}

	@Override
	public void remove(Long id) {
		categoryRepo.deleteById(id);

	}

}
