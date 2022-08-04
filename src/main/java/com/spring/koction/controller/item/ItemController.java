package com.spring.koction.controller.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.koction.entity.*;
import com.spring.koction.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.koction.commons.FileUtils;
import com.spring.koction.service.item.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;

	@Autowired
	UserService userService;

	//내 아이템 조회 /item/myItem
	@GetMapping("")
	public ModelAndView myItem(Item item) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("item/myItem.html");
		List<Item> myItemList = itemService.getMyItemList();
		mv.addObject("itemList", myItemList);
		return mv;
	}

	@GetMapping("/registerItem")
	public ModelAndView registerItemView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/item/itemRegister.html");
		return mv;
	}
	
	@PostMapping("/registerItem")
	public ModelAndView registerItem(Item item, int term, HttpServletRequest request, MultipartHttpServletRequest multipartServletRequest) throws IOException {
		item.setItemEnddate(item.getItemRegdate().plusDays(term));
		int itemNo = itemService.registerItem(item);//글등록 및 글 번호 반환
		
		FileUtils fileUtils = new FileUtils();
		List<ItemFile> fileList = fileUtils.parseFileInfo(itemNo, request, multipartServletRequest);
		
		for(ItemFile itemFile : fileList) {
			System.out.println(itemFile.getItem());
		}
		itemService.registerItemFile(fileList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/item/myItem");
		return mv;
	}
	
	@PostMapping("/updateItem")
	public void updateItem(Item item, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
		itemService.updateItem(item);
		FileUtils fileUtils = new FileUtils();
		List<ItemFile> fileList = fileUtils.parseFileInfo(item.getItemNo(), httpServletRequest, multipartHttpServletRequest);
		itemService.registerItemFile(fileList);
		httpServletResponse.sendRedirect("/item/myItem");
	}

	@GetMapping("/search")
	public ModelAndView searchView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/item/Search.html");


		return mv;
	}
	@GetMapping("/test")
	public ModelAndView testViewOrigin(@PathVariable int itemNo) {
		ModelAndView mv = new ModelAndView();
		List<Itemq> list = itemService.selectInquryList();
		mv.addObject("list",list);
		mv.setViewName("/item/ProductInfo");
		return mv;
	}

	@GetMapping("/test/{itemNo}")
	public ModelAndView testView(@PathVariable int itemNo) {
		ModelAndView mv = new ModelAndView();

		List<Itemq> list = itemService.selectInquryList();
		mv.addObject("list",list);
		mv.addObject("itemNo", itemNo);
//		System.out.println("itemNo////////////////////////"+itemNo);
		mv.setViewName("/item/ProductInfo");
		return mv;
	}

	@PostMapping("/inquiry")
	public ModelAndView testPost(Itemq itemq) {
		ModelAndView mv = new ModelAndView();
		System.out.println(itemq.getItem());
		itemService.insertInqury(itemq);
		mv.setViewName("redirect:/item/test/1");
		return mv;
	}
}
