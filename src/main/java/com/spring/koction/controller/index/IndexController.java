package com.spring.koction.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.service.item.ItemService;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/guide")
	public String guide() {
		return "/user/guide";
	}
	
	@RequestMapping("item/category")
	public String category(Model model) {
		List<ItemCategory> category = itemService.findCategory();
		model.addAttribute("category", category);
		return "/item/Category";
	}
	

	/*
	 * @RequestMapping("/guide") public String guide() { return "/project/guide"; }
	 */
	
	@RequestMapping("/support")
	public String surport() {
		return "/item/support";
	}
	
	@RequestMapping("/user/mypage")
	public String mypage() {
		return "/user/mypage";
	}
	
	@RequestMapping("/item")
	public String item() {
		return "/item/myItem";
	}


	@RequestMapping("/")
	public String index() {

		return "/index";
	}
}
