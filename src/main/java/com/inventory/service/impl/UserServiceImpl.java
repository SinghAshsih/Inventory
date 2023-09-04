package com.inventory.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.inventory.repository.UserRepo;
import com.inventory.security.UserPojo;
import com.inventory.service.UserService;

@Service
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override

	public UserPojo save(UserPojo user) {
		String pwd = user.getPassword();
		String encodedPwd = passwordEncoder.encode(pwd);
		user.setPassword(encodedPwd);
		return userRepo.save(user);
	}

	@Override
	public Iterable<UserPojo> get() {
		return userRepo.findAll();
	}

	@Override
	public UserPojo update(UserPojo user) {
		String pwd = user.getPassword();
		String encodedPwd = passwordEncoder.encode(pwd);
		user.setPassword(encodedPwd);
		return userRepo.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);

	}

	@Override
	public UserPojo findById(Long id) {
		Optional<UserPojo> opt = userRepo.findById(id);
		return opt.get();
	}

}
