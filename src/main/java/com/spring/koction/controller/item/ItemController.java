package com.spring.koction.controller.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	//내 아이템 조회 /item/myItem
	@GetMapping("/user/myItem")
	public String myItem() {
		return "myItem";
	}
	
	
	
	// 신규상품등록 페이지 이동 /item/register
	@GetMapping("/join")
	public ModelAndView join() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/join.html");
		return mv;
	}
	
}
