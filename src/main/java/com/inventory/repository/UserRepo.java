package com.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.inventory.security.UserPojo;

public interface UserRepo extends CrudRepository<UserPojo, Long> {

}
