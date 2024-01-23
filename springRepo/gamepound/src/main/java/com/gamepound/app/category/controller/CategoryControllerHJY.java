package com.gamepound.app.category.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.category.service.CategoryServiceHJY;
import com.gamepound.app.category.vo.CategoryVo;

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
	
	// 어드민 카테고리 수정하기
	@PutMapping("admin/edit")
	public ResponseEntity<String> categoryEdit(@RequestBody CategoryVo vo) {
		log.info("받아온 categoryVo : {}", vo);
		int result = service.categoryEdit(vo);
		if(result != 1) {
			return ResponseEntity.ok("bad");
		}
		return ResponseEntity.ok("good");
	}
	
	// 어드민 카테고리 생성하기
	@PostMapping("admin/create")
	public ResponseEntity<String> categoryCreate(@RequestBody CategoryVo vo) {
		log.info("받아온 categoryVo : {}", vo);
		int result = service.categoryCreate(vo);
		if(result != 1) {
			return ResponseEntity.ok("bad");
		}
		return ResponseEntity.ok("good");
	}
	
	// 어드민 카테고리 검색하기
	@GetMapping("admin/search")
	public Map<String, Object> categorySearch(String mainCategory, String subCategory, String pageNum) {
		log.info("search 메인카테고리명: {}, 서브카테고리명: {}, 페이지넘버: {}", mainCategory, subCategory, pageNum);
		boolean result = mainCategory.isEmpty();
		
		Map<String, String> searchVo = new HashMap<>();
		searchVo.put("mainCategory", mainCategory);
		searchVo.put("subCategory", subCategory);
		searchVo.put("pageNum", pageNum);
		Map<String, Object> map = service.categorySearch(searchVo);
		
		return map;
	}
	
	
}
