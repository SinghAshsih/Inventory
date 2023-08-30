package com.inventory.service;

import com.inventory.security.UserPojo;

public interface UserService {

	UserPojo save(UserPojo user);

	Iterable<UserPojo> get();

	UserPojo update(UserPojo user);

	void delete(Long id);

}
