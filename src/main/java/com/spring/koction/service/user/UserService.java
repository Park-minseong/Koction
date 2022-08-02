package com.spring.koction.service.user;

import com.spring.koction.entity.User;

public interface UserService {

	User idCheck(String userId);

	void join(User user);


}
