package com.gamepound.app.category.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.category.vo.SubCategoryVo;

@Repository
public class CategoryDaoHJY {

	// 카테고리 조회
	public ArrayList<CategoryVo> getCategory(SqlSessionTemplate sst) {
		List<CategoryVo> voList = sst.selectList("CategoryMapper.getCategory");
		
		// 메인카테고리
		Map<String, CategoryVo> map = new HashMap<String, CategoryVo>();
		for (CategoryVo categoryVo : voList) {
			map.put(categoryVo.getMainCategoryNo(), categoryVo);
		}
		
		// 서브카테고리
		for (CategoryVo categoryVo : voList) {
			
			SubCategoryVo subCategoryVo = new SubCategoryVo();
			subCategoryVo.setNo(categoryVo.getNo());
			subCategoryVo.setMainCategoryNo(categoryVo.getMainCategoryNo());
			subCategoryVo.setMainCategory(categoryVo.getMainCategory());
			subCategoryVo.setSubCategoryNo(categoryVo.getSubCategoryNo());
			subCategoryVo.setSubCategory(categoryVo.getSubCategory());
			
			CategoryVo target = map.get(subCategoryVo.getMainCategoryNo());
			target.getSubCategoryList().add(subCategoryVo);
		}
		
		ArrayList<CategoryVo> result = new ArrayList<CategoryVo>(map.values());
		
		return result;
	}

	// 메인 카테고리 조회
	public List<CategoryVo> getMainCategory(SqlSessionTemplate sst) {
		return sst.selectList("CategoryMaper.getMainCategory");
	}

	// 서브카테고리 조회
	public List<CategoryVo> getSubCategory(SqlSessionTemplate sst) {
		return sst.selectList("CategoryMaper.getSubCategory");
	}

}
