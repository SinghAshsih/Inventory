package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.UserRolePojo;
import com.inventory.exception_handling_code.ResourceNotFoundException;
import com.inventory.repository.UserRoleRepo;
import com.inventory.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	UserRoleRepo userRoleRepo;

	@Override
	public Iterable<UserRolePojo> get() {
		return userRoleRepo.findAll();
	}

	@Override
	public UserRolePojo save(UserRolePojo userRolePojo) {
		return userRoleRepo.save(userRolePojo);
	}

	@Override
	public UserRolePojo update(UserRolePojo userRolePojo) {
		return userRoleRepo.save(userRolePojo);
	}

	@Override
	public void delete(Long id) {
		userRoleRepo.deleteById(id);
	}

	@Override
	public UserRolePojo getById(Long id) {
//		Iterable<UserRolePojo> dataa = userRoleRepo.findAll();
//		boolean result;
//		int count = 0;
//		for (UserRolePojo role : dataa) {
//			result = role.getId().equals(id);
//			if (result == true) {
//				count++;
//			}
//		}
//		if (count == 0) {
//			throw new ResourceNotFoundException("User data is not present");
//		}
		

		Optional<UserRolePojo> data = userRoleRepo.findById(id);
		if (data.isPresent()) {
			return data.get();
		} else {
			throw new ResourceNotFoundException("User data is not present");
		}
	}
}
