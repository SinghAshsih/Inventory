package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.CategoryPojo;

public interface CategoryRepo extends CrudRepository<CategoryPojo, Long> {

}
