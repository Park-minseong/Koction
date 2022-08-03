package com.spring.koction.service.user;

import java.util.List;

import com.spring.koction.entity.User;

public interface UserService {

	User idCheck(String userId);

	void join(User user);
	
	User findLoginUser(String userId);

	void updateInfo(User user);
	
	


}
