package com.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inventory.repository.UserRepoSecurity;
import com.inventory.security.UserPojo;

@Service
public class UserServiceSecurity implements UserDetailsService {
	@Autowired
	UserRepoSecurity userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final UserPojo user = userRepo.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails userr = User.withUsername(user.getUserName()).password(user.getPassword()).authorities("USER")
				.build();
		return userr;
	}


}
