package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.entity.UserRolePojo;

public interface UserRoleRepo extends CrudRepository<UserRolePojo, Long> {

}
