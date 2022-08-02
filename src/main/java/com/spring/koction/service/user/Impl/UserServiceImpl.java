package com.spring.koction.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.User;
import com.spring.koction.repository.UserRepository;
import com.spring.koction.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User idCheck(String userId) {
		// TODO Auto-generated method stub
		if(userRepository.findById(userId).isPresent()) {
			return userRepository.findById(userId).get();
		} else {
			return null;
		}
	}

	@Override
	public void join(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}
	

}
