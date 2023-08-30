package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.security.UserPojo;

public interface UserRepoSecurity extends JpaRepository<UserPojo, Long> {
	UserPojo findByUserName(String userName);
}
