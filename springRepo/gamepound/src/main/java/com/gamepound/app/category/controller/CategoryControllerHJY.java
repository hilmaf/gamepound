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

import lombok.RequiredArgsConstructor;

@RequestMapping("category")
@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
public class CategoryControllerHJY {
	
	private final CategoryServiceHJY service;
	
	// 카테고리 조회
	@GetMapping("list")
	public ArrayList<CategoryVo> getCategory() {
		ArrayList<CategoryVo> result = service.getCategory();
		return result;
	}

	// 메인카테고리 조회
	@GetMapping("getMainCategory")
	public List<CategoryVo> getMainCategory() {
		List<CategoryVo> voList = service.getMainCategory();
		return voList;
	}
	
	// 메인카테고리 조회
	@GetMapping("getMainCategory")
	public List<CategoryVo> getSubCategory() {
		List<CategoryVo> voList = service.getSubCategory();
		return voList;
	}
	
	
}
