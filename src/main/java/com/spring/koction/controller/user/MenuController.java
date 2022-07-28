package com.spring.koction.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	@RequestMapping("/guide")
	public String guide() {
		return "/project/guide";
	}
	
	@RequestMapping("/category")
	public String category() {
		return "/project/Category";
	}
	
	/*
	 * @RequestMapping("/guide") public String guide() { return "/project/guide"; }
	 */
	
	@RequestMapping("/support")
	public String surport() {
		return "/project/support";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "/project/mypage";
	}
	
	@RequestMapping("/item")
	public String item() {
		return "/project/_02_myitem_register";
	}
	
}
