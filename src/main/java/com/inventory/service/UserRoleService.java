package com.inventory.service;

import com.inventory.entity.UserRolePojo;

public interface UserRoleService {

	Iterable<UserRolePojo> get();

	UserRolePojo save(UserRolePojo userRolePojo);

	UserRolePojo update(UserRolePojo userRolePojo);

	void delete(Long id);

	UserRolePojo getById(Long id);

}
