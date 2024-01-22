package com.gamepound.app.category.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.category.service.CategoryServiceHJY;
import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.page.vo.PageVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("category")
@RequiredArgsConstructor
@RestController
public class CategoryControllerHJY {
	
	private final CategoryServiceHJY service;
	
	// 카테고리 조회
	@GetMapping("list")
	public ArrayList<CategoryVo> getCategory() {
		ArrayList<CategoryVo> result = service.getCategory();
		return result;
	}
	
	// 어드민 카테고리 리스트 조회
	@GetMapping("admin/list")
	public Map<String, Object> getCategoryList(String pageNum) {
		
        Map<String, Object> map = service.getCategoryList(pageNum);
        log.info("카테고리 리스트 : {}", map.get("categoryList"));
        List<CategoryVo> list = (List<CategoryVo>) map.get("categoryList");
        log.info("카테고리 리스트 : {}", list.size());
        
        return map;
	}
	
	// 어드민 카테고리 상세 조회
	@GetMapping("admin/detail")
	public CategoryVo getCategoryDetail(String no) {
		CategoryVo vo = service.getCategoryDetail(no);
		return vo;
	}
	
	
}
