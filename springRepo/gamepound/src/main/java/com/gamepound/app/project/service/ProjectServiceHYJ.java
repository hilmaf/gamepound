package com.gamepound.app.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoHYJ;
import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;
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

	//목록 조회 - 공개예정
	public List<ProjectVo> projectListPrelaunch() {
		return dao.projectListPrelaunch(sst);
	}

	//프로젝트 상세 조회 - 프로젝트 계획
	public Map<String, Object> projectDetailStory(String no) {
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("projectDetail", dao.projectDetail(sst, no));
		map.put("projectStory", dao.projectStory(sst, no));
		return map;
	}

	//프로젝트 상세 조회 - 업데이트
	public List<ProjectUpdateVo> projectDetailUpdate(String no) {
		return dao.projectDetailUpdate(sst, no);
	}

	//프로젝트 상세 조회 - 커뮤니티
	public List<ProjectCommunityVo> projectDetailCommunity(String no) {
		return dao.projectDetailCommunity(sst, no);
	}


}
