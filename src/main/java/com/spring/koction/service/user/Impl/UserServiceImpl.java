package com.spring.koction.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.User;
import com.spring.koction.mapper.ItemMapper;
import com.spring.koction.repository.UserRepository;
import com.spring.koction.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemMapper itemMapper;

	@Override
	public User idCheck(String userId) {
		// TODO Auto-generated method stub
		if (userRepository.findById(userId).isPresent()) {
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

	@Override
	public User findLoginUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

	@Override
	public void updateInfo(User user) {
		userRepository.save(user);

	}

	@Override
	public void updatePw(User user) {
		itemMapper.updateUserPw(user);

	}

	
}
