package com.spring.koction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(String UserId);

	void save(String userPw);
}
