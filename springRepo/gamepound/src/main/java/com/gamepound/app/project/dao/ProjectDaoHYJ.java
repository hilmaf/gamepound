package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class ProjectDaoHYJ {

	//목록 조회 - 카테고리
	public List<ProjectVo> projectListCategory(SqlSessionTemplate sst, ProjectListVo vo) {
		return sst.selectList("ProjectMapper.ListCategory", vo);
	}

	//목록 조회 - 인기순
	public List<ProjectVo> projectListPopular(SqlSessionTemplate sst, ProjectListVo vo) {
		//TODO-HYJ : [list-popular] mapper작성해야함
		return sst.selectList("ProjectMapper.ListPopular", vo);
	}

	//목록 조회 - 신규
	public List<ProjectVo> projectListNew(SqlSessionTemplate sst, ProjectListVo vo) {
		return sst.selectList("ProjectMapper.ListNew", vo);
	}

}
