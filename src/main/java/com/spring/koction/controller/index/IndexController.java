package com.spring.koction.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/guide")
	public String guide() {
		return "/user/guide";
	}
	
	@RequestMapping("/category")
	public String category() {
		return "/item/Category";
	}
	
	/*
	 * @RequestMapping("/guide") public String guide() { return "/project/guide"; }
	 */
	
	@RequestMapping("/support")
	public String surport() {
		return "/item/support";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "/user/mypage";
	}
	
	@RequestMapping("/item")
	public String item() {
		return "/item/itemRegisterList";
	}
	
}
