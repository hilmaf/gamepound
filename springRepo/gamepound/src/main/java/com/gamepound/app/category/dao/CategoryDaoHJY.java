package com.gamepound.app.category.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.category.vo.SubCategoryVo;
import com.gamepound.app.page.vo.PageVo;

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

	// 카테고리 전체 개수 조회
	public int selectCategoryCount(SqlSessionTemplate sst) {
		return sst.selectOne("CategoryMapper.selectCategoryCount");
	}

	// 어드민 카테고리 리스트 조회
	public List<CategoryVo> getCategoryList(SqlSessionTemplate sst, PageVo pvo) {
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); // 몇개의 게시물 건너뛸건지
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("CategoryMapper.getCategoryList", null, rb);
	}

	// 어드민 카테고리 상세 조회
	public CategoryVo getCategoryDetail(SqlSessionTemplate sst, String no) {
		return sst.selectOne("CategoryMapper.getCategoryDetail", no);
	}

	// 어드민 카테고리 수정하기
	public int categoryEdit(SqlSessionTemplate sst, CategoryVo vo) {
		return sst.update("CategoryMapper.categoryEdit", vo);
	}

	// 어드민 카테고리 생성하기
	public int categoryCreate(SqlSessionTemplate sst, CategoryVo vo) {
		return sst.update("CategoryMapper.categoryCreate", vo);
	}

	// 어드민 카테고리 검색하기 총 갯수
	public int categorySearchCnt(SqlSessionTemplate sst, CategoryVo searchVo) {
		return sst.selectOne("CategoryMapper.categorySearchCnt", searchVo);
	}

	// 어드민 카테고리 검색하기 결과
	public List<CategoryVo> getSearchCategoryList(SqlSessionTemplate sst, CategoryVo searchCategoryVo, PageVo pvo) {
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); // 몇개의 게시물 건너뛸건지
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("CategoryMapper.getSearchCategoryList", searchCategoryVo, rb);
	}

}
