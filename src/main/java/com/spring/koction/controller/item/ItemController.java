package com.spring.koction.controller.item;

import com.spring.koction.commons.FileUtils;
import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	//내 아이템 조회 /item/myItem
	@GetMapping("/myItem")
	public ModelAndView getMyItem(Item item) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("item/myItem.html");
		return mv;
//	public String myItem() {
//		return "myItem";
	}


	@GetMapping("/registerItem")
	public ModelAndView bidView() {
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@PostMapping("/registerItem")
	public void insertBoard(HttpServletResponse httpServletResponse, Item item, HttpServletRequest httpServletRequest, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
		int itemNo = itemService.registerItem(item);
		FileUtils fileUtils = new FileUtils();
		List<ItemFile> fileList = fileUtils.parseFileInfo(itemNo, httpServletRequest, multipartHttpServletRequest);
		itemService.registerItemFileList(fileList);
		httpServletResponse.sendRedirect("/item/myItem");
	}
	
	@PostMapping("/updateItem")
	public void updateItem(Item item, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest, MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
		itemService.updateItem(item);
		FileUtils fileUtils = new FileUtils();
		List<ItemFile> fileList = fileUtils.parseFileInfo(item.getItemNo(), httpServletRequest, multipartHttpServletRequest);
		itemService.registerItemFileList(fileList);
		httpServletResponse.sendRedirect("/item/myItem");
	}

}
