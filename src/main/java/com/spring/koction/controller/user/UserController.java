package com.spring.koction.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.koction.entity.User;
import com.spring.koction.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//로그인 페이지 이동
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/login.html");
		return mv;
	}
	
	
	
	//회원가입 페이지 이동
	@GetMapping("/join")
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/join.html");
		return mv;
	}
	
	//회원가입
	@PostMapping("/join")
	public ModelAndView join(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login.html");
		
		String pw = user.getUserPw();
		user.setUserPw(passwordEncoder.encode(pw));
		
		userService.join(user);
		
		return mv;
	}
	
	//아이디 중복체크
	@PostMapping("/idCheck")
	public String idCheck(User user) {
		User idCheck = userService.idCheck(user.getUserId());
		
		if(idCheck == null) {
			return "idOK";
		} else {
			return "idFail";
		}
	}
	
	
}
