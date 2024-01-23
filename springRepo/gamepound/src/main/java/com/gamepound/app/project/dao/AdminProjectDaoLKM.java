package com.gamepound.app.project.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.page.vo.PageVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectSearchVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class AdminProjectDaoLKM {

	// 프로젝트 목록 cnt
	public String cntProjects(SqlSessionTemplate sst) {
		return sst.selectOne("AdminProjectMapper.cntProjects");
	}
	
	// 프로젝트 목록 조회
	public List<ProjectVo> list(SqlSessionTemplate sst, PageVo pvo) {
		int offset = (pvo.getCurrentPage()-1) * pvo.getBoardLimit();
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("AdminProjectMapper.list", null, rb);
	}

	// 프로젝트 상세 조회
	public List<ProjectDetailVo> detail(SqlSessionTemplate sst, String projectNo) {
		return sst.selectList("AdminProjectMapper.detail", projectNo);
	}

	// 프로젝트 승인 처리
	public int approve(SqlSessionTemplate sst, String projectNo) {
		return sst.update("AdminProjectMapper.approve", projectNo);
	}

	// 프로젝트 반려 처리
	public int reject(SqlSessionTemplate sst, String projectNo) {
		return sst.update("AdminProjectMapper.reject", projectNo);
	}

	// 프로젝트 검색결과 조회
	public List<ProjectVo> search(SqlSessionTemplate sst, ProjectSearchVo vo) {
		return sst.selectList("AdminProjectMapper.search", vo);
	}
	
	// 프로젝트 검색결과 cnt

}
