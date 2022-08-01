package com.spring.koction.controller.item;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.koction.commons.FileUtils;
import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.service.item.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController1 {
	
	@Autowired
	ItemService itemService;

	@GetMapping("/registerItem")
	public ModelAndView registerItemView() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/item/itemRegister.html");
		return mv;
	}
	
	@PostMapping("/registerItem")
	public ModelAndView registerItem(Item item, int term, HttpServletRequest request, MultipartHttpServletRequest multipartServletRequest) throws IOException {
		item.setItemEnddate(item.getItemRegdate().plusDays(term));
		int itemNo = itemService.regitserItem(item);//글등록 및 글 번호 반환
		
		FileUtils fileUtils = new FileUtils();
		List<ItemFile> fileList = fileUtils.parseFileInfo(itemNo, request, multipartServletRequest);
		
		itemService.registerItemFile(fileList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/item/itemRegister.html");
		return mv;
	}
}
