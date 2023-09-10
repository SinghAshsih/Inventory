package com.inventory.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.CategoryPojo;
import com.inventory.service.CategoryService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/category")
public class CategoryController {
	Logger logger = (Logger) LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public Iterable<CategoryPojo> getAll() {
		logger.info("In getAll method");
		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	public CategoryPojo getById(@PathVariable Long id) {
		return categoryService.getById(id);
	}

	@PostMapping
	public CategoryPojo save(@RequestBody CategoryPojo category) {
		return categoryService.Save(category);
	}

	@PutMapping
	public CategoryPojo update(@RequestBody CategoryPojo category) {
		return categoryService.update(category);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		categoryService.remove(id);
		return "Delete successfully";
	}
}
