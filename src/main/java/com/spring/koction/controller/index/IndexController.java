package com.spring.koction.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.service.item.ItemService;


@Controller
public class IndexController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/guide")
	public String guide() {
		return "/user/guide";
	}
	
	@RequestMapping("/category")
	public String category(Model model) {
		List<ItemCategory> category = itemService.findCategory();
		model.addAttribute("category", category);
		return "/item/Category";
	}
	
	@RequestMapping("/item/search/{categoryNo}")
	public String category(@PathVariable int categoryNo, Model model) {
		List<Item> category = itemService.findCategory(categoryNo);
		model.addAttribute("itemlist", category);
		return "/item/Search";
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
