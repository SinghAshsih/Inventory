package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entity.UserRolePojo;
import com.inventory.service.UserRoleService;

@RestController
@RequestMapping("/role")
public class UserRoleController {
	@Autowired
	UserRoleService userRoleService;

	@GetMapping
	public Iterable<UserRolePojo> get() {
		return userRoleService.get();
	}

	@PostMapping
	public UserRolePojo save(@RequestBody UserRolePojo userRolePojo) {
		return userRoleService.save(userRolePojo);
	}
	@PutMapping
	public UserRolePojo update(@RequestBody UserRolePojo userRolePojo) {
		return userRoleService.update(userRolePojo);
	}
	@DeleteMapping("/{id}")
	public String detele(@PathVariable Long id) {
		userRoleService.delete(id);
		return "Delete Successfully";
	}
	@GetMapping("/{id}")
	public UserRolePojo getById(@PathVariable Long id) {
		
		return userRoleService.getById(id);
	}
	

}
