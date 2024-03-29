package com.gamepound.app.category.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.category.dao.CategoryDaoHJY;
import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.page.vo.PageVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceHJY {
	
	private final CategoryDaoHJY dao;
	private final SqlSessionTemplate sst;
	
	// 카테고리 조회
	public ArrayList<CategoryVo> getCategory() {
		return dao.getCategory(sst);
	}

	// 어드민 카테고리 리스트 조회
	public Map<String, Object> getCategoryList(String pageNum) {
		
		int listCount = dao.selectCategoryCount(sst);       //전체 게시글 갯수
        log.info("전체 게시글 개수 : {}", listCount);
        String currentPage_= pageNum;
        if(currentPage_ == null) {
        	currentPage_ = "1";
        }
        int currentPage = Integer.parseInt(currentPage_);   //현재 페이지
        int pageLimit = 5; 									// 페이지 영역 페이지 개수
        int boardLimit = 10; 								// 한 페이지에 보여줄 게시글 개수
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        log.info("pvo : {}", pvo);
        List<CategoryVo> listVo = dao.getCategoryList(sst, pvo);
		
        // 카테고리 리스트와 pvo 같이 전달
        Map<String, Object> map = new HashMap<>();
        map.put("categoryList", listVo);
        map.put("pvo", pvo);
		
		return map;
	}

	// 어드민 카테고리 상세 조회
	public CategoryVo getCategoryDetail(String no) {
		return dao.getCategoryDetail(sst, no);
	}

	// 어드민 카테고리 수정하기
	public int categoryEdit(CategoryVo vo) {
		return dao.categoryEdit(sst, vo);
	}

	// 어드민 카테고리 생성하기
	public int categoryCreate(CategoryVo vo) {
		return dao.categoryCreate(sst, vo);
	}

	// 어드민 카테고리 검색하기
	public Map<String, Object> categorySearch(Map<String, String> searchVo) {
		log.info("search serviceVo : {}", searchVo);
		log.info("search serviceVo mainCategory : '{}'", searchVo.get("mainCategory"));
		log.info("search serviceVo subCategory : '{}'", searchVo.get("subCategory"));
		
		CategoryVo searchCategoryVo = new CategoryVo();
		searchCategoryVo.setMainCategory(searchVo.get("mainCategory"));
		searchCategoryVo.setSubCategory(searchVo.get("subCategory"));
		
		int listCount = dao.categorySearchCnt(sst, searchCategoryVo);       // 검색 게시글 갯수
        log.info("검색 게시글 갯수 : {}", listCount);
        
        String currentPage_= searchVo.get("pageNum");
        if(currentPage_ == null) {
        	currentPage_ = "1";
        }
        int currentPage = Integer.parseInt(currentPage_);   		//현재 페이지
        int pageLimit = 5; 											// 페이지 영역 페이지 개수
        int boardLimit = 10; 										// 한 페이지에 보여줄 게시글 개수
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        log.info("pvo : {}", pvo);
        List<CategoryVo> listVo = dao.getSearchCategoryList(sst, searchCategoryVo, pvo);
		
        // 카테고리 검색 리스트와 pvo 같이 전달
        Map<String, Object> map = new HashMap<>();
        map.put("categoryList", listVo);
        map.put("pvo", pvo);
        
		return map;
	}

}
