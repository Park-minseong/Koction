package com.spring.koction.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("item/category")
	public String category(Model model) {
		List<ItemCategory> category = itemService.findCategory();
		model.addAttribute("category", category);
		return "/item/Category";
	}
	
	@RequestMapping("/item/search/{categoryNo}")
	public String category(@PathVariable int categoryNo, Model model,@PageableDefault(page = 0, size = 6, sort="itemNo" ,direction=Direction.DESC) Pageable pageable) {
		Page<Item> itemList = itemService.findCategory(categoryNo, pageable);
		System.out.println(itemList);
		for(Item item:itemList) {
			if(itemService.findItemFilesByItemNo(item.getItemNo()).size() != 0) {
				item.setItemFile(itemService.findItemFilesByItemNo(item.getItemNo()).get(0));
			}
		}
		
		model.addAttribute("itemList1", itemList);
		return "/item/Search";
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
	
	
	//index 핫딜
		@GetMapping("/")
		public ModelAndView hotProc(Item item) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/index.html");
			List<Item> hotProc = itemService.hotProcSort();
			List<Item> endProc = itemService.endProcSort();
			
			
			for(Item item1:hotProc) {
				if(itemService.findItemFilesByItemNo(item1.getItemNo()).size() != 0) {
					item1.setItemFile(itemService.findItemFilesByItemNo(item1.getItemNo()).get(0));
				}
			}
			
			mv.addObject("hotProcList", hotProc);
			mv.addObject("endProcList", endProc);
			return mv;
		}
		
	
}
