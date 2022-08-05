package com.spring.koction.controller.item;

import com.spring.koction.commons.FileUtils;
import com.spring.koction.dto.ItemqDto;
import com.spring.koction.dto.OrderDto;
import com.spring.koction.entity.*;
import com.spring.koction.service.item.ItemService;
import com.spring.koction.service.user.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

	@Autowired
	UserService userService;

	//내 아이템 조회 /item/myItem
	@GetMapping("")
	public ModelAndView myItem(Item item, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("item/myItem.html");
		String test = customUserDetails.getUsername();
		List<Item> myItemList = itemService.getMyItemList(test);
		for(Item item1:myItemList) {
			if(itemService.findItemFilesByItemNo(item1.getItemNo()).size() != 0) {
				item1.setItemFile(itemService.findItemFilesByItemNo(item1.getItemNo()).get(0));
			}
		}
		mv.addObject("itemList", myItemList);
//		mv.addObject("itemFile", myItemFile);

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
		mv.setViewName("redirect:/item"); // myitem이 아니라 item으로 보내야해서 수정함
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

//	@GetMapping("/test")
//	public ModelAndView testViewOrigin(@PathVariable int itemNo) {
//		ModelAndView mv = new ModelAndView();
//		List<ItemqDto> list = itemService.selectInquryList();
//		mv.addObject("list",list);
//		mv.setViewName("/item/ProductInfo");
//		return mv;
//	}

	//0804 상세 페이지랑 합치는 작업중
//	@GetMapping("/test/{itemNo}")
//	public ModelAndView testView(@PathVariable int itemNo) {
//		ModelAndView mv = new ModelAndView();
//
//		List<ItemqDto> list = itemService.selectInquryList();
//		for(ItemqDto itemq : list) {
//			System.out.println(itemq.toString());
//		}
//
//		mv.addObject("list",list);
//		mv.addObject("itemNo", itemNo);
////		System.out.println("itemNo////////////////////////"+itemNo);
//		mv.setViewName("/item/ProductInfo");
//		return mv;
//	}

	
	@GetMapping("/search/{categoryNo}")
	public ModelAndView category(@PathVariable int categoryNo, Model model,@PageableDefault(page = 0, size = 6, sort="itemNo" ,direction=Direction.DESC) Pageable pageable) {
		ModelAndView mv = new ModelAndView();
		Page<Item> itemList = itemService.findCategory(categoryNo, pageable);
		System.out.println(itemList);
		for(Item item:itemList) {
			if(itemService.findItemFilesByItemNo(item.getItemNo()).size() != 0) {
				item.setItemFile(itemService.findItemFilesByItemNo(item.getItemNo()).get(0));
			}
		}
		mv.setViewName("/item/search.html");
		mv.addObject("itemList1", itemList);
		return mv;
	}

	@PostMapping("/inquiry")
	public ModelAndView testPost(Itemq itemq) {
		ModelAndView mv = new ModelAndView();
//		itemq.getItem().setItemNo(itemNo);


//		System.out.println("itemNo////////////////////////"+itemNo);
//		System.out.println("itemq////////////////////////"+itemq.getItem().getItemNo());
//		System.out.println("itemq////////////////////////"+itemq);

		System.out.println(itemq.getItem());
//		itemq.getItem().setItemNo(itemNo);
		int itemqNo = itemService.insertInqury(itemq);
		System.out.println("//////////////////"+itemq.getItem().getItemNo());
		mv.setViewName("redirect:/item/searchItem/" +itemq.getItem().getItemNo());
		return mv;
	}

	@PostMapping("/modalbid")
	public ModelAndView modalPost(Order order) {
		ModelAndView mv = new ModelAndView();
		OrderDto orderDto = new OrderDto();
//		itemService.insertOrder(orderDto);
		int orderNo = itemService.insertOrder(order);
		mv.setViewName("redirect:/item/searchItem/" +order.getItem().getItemNo());
		return mv;
	}

	@GetMapping("/modalbid")
	public ModelAndView modalGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/login");
		return mv;
	}

	@PostMapping("/test/deleteTest")
	public void deleteTest(int itemqNo, int itemNo){
		System.out.println("itemqNo========================================================="+itemqNo);
		itemService.deleteTest(itemqNo, itemNo);
  	}

	@GetMapping("/searchItem/{itemNo}")
	public ModelAndView searchItemView(@PathVariable int itemNo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/item/ProductInfo.html");

//		List<Itemq> list = itemService.selectInquryList(itemNo);

		List<ItemqDto> list = itemService.selectInquryList(itemNo);

		Item item = itemService.getItem(itemNo);
		List<ItemFile> fileList = itemService.getItemFileList(itemNo);


		mv.addObject("item", item);
		mv.addObject("fileList", fileList);
		mv.addObject("list",list);
		mv.addObject("itemNo", itemNo);

		itemService.updateItemCnt(itemNo);
		
		return mv;
	}


}
