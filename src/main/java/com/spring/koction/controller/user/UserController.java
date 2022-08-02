package com.spring.koction.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	//로그인 페이지 이동
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/login.html");
		return mv;
	}
	
	@PostMapping("/login")
	public String login(User user, HttpSession session) {
		User loginUser = userService.idCheck(user.getUserId());
				if(loginUser == null) {
					return "idFail";
				}else{
					if(!loginUser.getUserPw().equals(user.getUserPw())) {
				return "pwFail";
			} else {
				session.setAttribute("loginUser", loginUser);
				return "loginSuccess";
			}
		}
	
	}
	
	
	//회원가입 페이지 이동
	@GetMapping("/join")
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/join.html");
		return mv;
	}
	
	@GetMapping("/mypage")
	public ModelAndView mypage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/mypage.html");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/login.html");
		return mv;
	}
	
	//회원정보수정
	@GetMapping("/modifyInfo")
	public ModelAndView modifyInfo() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/modifyInfo.html");
		return mv;
	}
	


}
