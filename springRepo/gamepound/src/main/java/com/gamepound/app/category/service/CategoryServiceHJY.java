package com.gamepound.app.category.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.category.dao.CategoryDaoHJY;
import com.gamepound.app.category.vo.CategoryVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceHJY {
	
	private final CategoryDaoHJY dao;
	private final SqlSessionTemplate sst;
	
	// 카테고리 조회
	public ArrayList<CategoryVo> getCategory() {
		return dao.getCategory(sst);
	}

	// 메인카테고리 조회
	public List<CategoryVo> getMainCategory() {
		return dao.getMainCategory(sst);
	}

}
