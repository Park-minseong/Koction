package com.spring.koction.service.user.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.User;
import com.spring.koction.repository.UserRepository;

//SecurityConfig.java에 설정한 .loginProcessionUrl("/user/loginProc");
// /user/loginProc 요청이 오면 자동으로 UserDetailsService의 loadUserByUsername가 실행되게 됨
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			return null;
		}else {
			//시큐리티 세션 정보가 등록됨
			return new CustomUserDetails(user);
		}
	}
	
}
