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
import com.gamepound.app.project.vo.ProjectStoryVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHYJ {
	private final ProjectDaoHYJ dao;
	private final SqlSessionTemplate sst;
	private final DataProcessingUtil util;
	
	//목록 조회 - 카테고리
	public List<ProjectVo> projectListCategory(ProjectListVo vo) {
		
		List<ProjectVo> voList = dao.projectListCategory(sst, vo);
		
		//추가
		add(voList);
		listAddPath(voList);
		
		return voList;
	}

	//목록 조회 - 인기순
	public List<ProjectVo> projectListPopular(ProjectListVo vo) {
		List<ProjectVo> voList = dao.projectListPopular(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);

		return voList;
	}

	//목록 조회 - 신규
	public List<ProjectVo> projectListNew(ProjectListVo vo) {
		List<ProjectVo> voList = dao.projectListNew(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);
		
		return voList;
	}

	//목록 조회 - 마감임박
	public List<ProjectVo> projectListImminent(ProjectListVo vo) {
		List<ProjectVo> voList = dao.projectListImminent(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);
		return voList;
	}

	//목록 조회 - 공개예정
	public List<ProjectVo> projectListPrelaunch() {
		List<ProjectVo> voList = dao.projectListPrelaunch(sst);
		listAddPath(voList);
		return voList;
	}
	
	
	//List에 달성률, 남은 시간 추가
	public void add(List<ProjectVo>voList) {
		for (ProjectVo vo : voList) {
			vo.setAchievementRate(util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount()));
			System.out.println(vo.getEndDate());
			vo.setRemainingPeriod(util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일"));
		}
	}
	
	//db에서 사진 가져올때 사진 경로 추가
	public void listAddPath(List<ProjectVo>voList) {
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/projectImg/";
		for (ProjectVo vo : voList) {
			vo.setImageUrl(localAddr + path + vo.getImageUrl());
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//프로젝트 상세 조회 - 타이틀
	public ProjectDetailVo projectDetail(String no) {
		ProjectDetailVo vo = dao.projectDetail(sst, no);
		
		//후원자 수 추가
		String totalBackerNo = dao.projectDetailTotalBackerNo(sst, no).getTotalBackerNo();
		vo.setTotalBackerNo(totalBackerNo);
		
		//퍼센트 추가
		DataProcessingUtil util = new DataProcessingUtil();
		vo.setAchievementRate(util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount()));
		
		//남은 시간 추가
		vo.setRemainingPeriod(util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일"));
		
		//사진 경로 추가
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/projectImg/";
		vo.setImageUrl(localAddr + path + vo.getImageUrl());
		
		return vo;
	}

	//프로젝트 상세 조회 - 프로젝트 계획
	public ProjectStoryVo projectDetailStory(String no) {
		return dao.projectDetailStory(sst, no);
	}

	//프로젝트 상세 조회 - 업데이트
	public List<ProjectUpdateVo> projectDetailUpdate(String no) {
		return dao.projectDetailUpdate(sst, no);
	}

	//프로젝트 상세 조회 - 커뮤니티
	public List<ProjectCommunityVo> projectDetailCommunity(String no) {
		return dao.projectDetailCommunity(sst, no);
	}

	//프로젝트 상세 조회 - 업데이트 작성
	public int projectDetailUpdate(ProjectUpdateVo vo) {
		return dao.projectDetailUpdate(sst, vo);
	}

	//프로젝트 상세 조회 - 커뮤니티 작성
	public int projectDetailCommunity(ProjectCommunityVo vo) {
		int result = 0;
		if(vo.getNo()!=null&&vo.getNo()!="") {
			result = dao.projectDetailCommunityReply(sst, vo);
		}else {
			result = dao.projectDetailCommunity(sst, vo);
		}
		return result;
	}
	


	////////////////////////////////////////////////////////////////////////////////////////////////
	





}
