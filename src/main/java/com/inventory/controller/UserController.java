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

import com.inventory.security.UserPojo;
import com.inventory.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping
	public UserPojo save(@RequestBody UserPojo user) {
		return userService.save(user);
	}

	@GetMapping
	public Iterable<UserPojo> get() {
		return userService.get();
	}

	@PutMapping
	public UserPojo update(@RequestBody UserPojo user) {
		return userService.update(user);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "Delete Successfully";

	}
}
