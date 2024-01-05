package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoHYJ;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHYJ {
	private final ProjectDaoHYJ dao;
	private final SqlSessionTemplate sst;
	
	//목록 조회 - 카테고리
	public List<ProjectVo> projectListCategory(ProjectListVo vo) {
		//TODO-HYJ : [list-category] vo에 달성률 남은 기간 너어야함
		return dao.projectListCategory(sst, vo);
	}

	//목록 조회 - 인기순
	public List<ProjectVo> projectListPopular(ProjectListVo vo) {
		//TODO-HYJ : [list-popular] vo에 달성률 남은 기간 너어야함
		return dao.projectListPopular(sst, vo);
	}

	//목록 조회 - 신규
	public List<ProjectVo> projectListNew(ProjectListVo vo) {
		//TODO-HYJ : [list-new] vo에 달성률 남은 기간 너어야함
		return dao.projectListNew(sst, vo);
	}

	//목록 조회 - 마감임박
	public List<ProjectVo> projectListImminent(ProjectListVo vo) {
		//TODO-HYJ : [list-imminent] vo에 달성률 남은 기간 너어야함
		return dao.projectListImminent(sst, vo);
	}
}
