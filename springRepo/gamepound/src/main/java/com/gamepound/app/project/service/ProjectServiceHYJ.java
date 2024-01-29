package com.gamepound.app.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoHYJ;
import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailCntVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectStoryVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceHYJ {
	private final ProjectDaoHYJ dao;
	private final SqlSessionTemplate sst;
	private final DataProcessingUtil util;
	
	//목록 조회 - 카테고리
	public Map<String, Object> projectListCategory(ProjectListVo vo) {
		//달성률 추가
		achievementRate(vo);
		
		log.info("vo ::: {}",vo);
		
		List<ProjectVo> voList = dao.projectListCategory(sst, vo);
		
		//추가
		add(voList);
		listAddPath(voList);
		
		Map<String, Object>map = cntProject(voList);
		
		return map;
	}

	//목록 조회 - 인기순
	public Map<String, Object> projectListPopular(ProjectListVo vo) {
		
		//달성률 추가
		achievementRate(vo);
		
		List<ProjectVo> voList = dao.projectListPopular(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);

		Map<String, Object>map = cntProject(voList);
		
		return map;
	}

	//목록 조회 - 신규
	public Map<String, Object> projectListNew(ProjectListVo vo) {
		//달성률 추가
		achievementRate(vo);
		
		List<ProjectVo> voList = dao.projectListNew(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);
		
		Map<String, Object>map = cntProject(voList);
		
		return map;
	}

	//목록 조회 - 마감임박
	public Map<String, Object> projectListImminent(ProjectListVo vo) {
		//달성률 추가
		achievementRate(vo);
		
		List<ProjectVo> voList = dao.projectListImminent(sst, vo);
		//추가
		add(voList);
		listAddPath(voList);
		
		Map<String, Object>map = cntProject(voList);
		
		return map;
	}

	//목록 조회 - 공개예정
	public Map<String, Object> projectListPrelaunch() {
		List<ProjectVo> voList = dao.projectListPrelaunch(sst);
		listAddPath(voList);
		
		Map<String, Object>map = cntProject(voList);
		
		return map;
	}
	
	
	//List에 달성률, 남은 시간 추가
	public void add(List<ProjectVo>voList) {
		for (ProjectVo vo : voList) {
			vo.setAchievementRate(util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount()));
			vo.setRemainingPeriod(util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일"));
		}
	}
	
	//db에서 프로젝트 사진 가져올때 사진 경로 추가(List)
	public void listAddPath(List<ProjectVo>voList) {
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/projectImg/";
		for (ProjectVo vo : voList) {
			vo.setImageUrl(localAddr + path + vo.getImageUrl());
		}
	}
	
	//전체 개수 추가
	public Map<String, Object> cntProject(List<ProjectVo> voList) {
		int projectPcs = voList.size();
		Map<String, Object> map = new HashMap<>();
		map.put("projectPcs", projectPcs);
		map.put("voList", voList);
		
		return map;
	}
	
	//달성률 추가
	public void achievementRate(ProjectListVo vo) {
		String achievementRate = vo.getAchievementRate();
		if(achievementRate.equals("under75")) {
			vo.setAchievementRateEnd("75");
		}else if(achievementRate.equals("between")) {
			vo.setAchievementRateStart("75");
			vo.setAchievementRateEnd("100");
		}else if(achievementRate.equals("over100")) {
			vo.setAchievementRateStart("100");
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//프로젝트 상세 조회 - 타이틀
	public Map<String, Object> projectDetail(String no) {
		ProjectDetailVo vo = dao.projectDetail(sst, no);
		
		//후원자 수 추가
		String totalBackerNo = dao.projectDetailTotalBackerNo(sst, no).getTotalBackerNo();
		vo.setTotalBackerNo(totalBackerNo);
		
		//퍼센트 추가
		DataProcessingUtil util = new DataProcessingUtil();
		vo.setAchievementRate(util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount()));
		
		//남은 시간 추가
		vo.setRemainingPeriod(util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일"));
		
		//프로젝트 사진 경로 추가
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String projectPath = "/resources/images/projectImg/";
		String creatorPath = "/resources/images/memberProfileImg/";
		vo.setImageUrl(localAddr + projectPath + vo.getImageUrl());
		vo.setMemberPic(localAddr + creatorPath + vo.getMemberPic());
		
		//프로젝트 업데이트 수 + 커뮤니티 수 + 창작자 번호
		ProjectDetailCntVo detailCntVo = dao.projectCnt(sst, no);
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("detailVo", vo);
		map.put("detailCntVo", detailCntVo);
		
		return map;
	}

	//프로젝트 상세 조회 - 프로젝트 계획
	public ProjectStoryVo projectDetailStory(String no) {
		return dao.projectDetailStory(sst, no);
	}

	//프로젝트 상세 조회 - 업데이트
	public Map<String, Object> projectDetailUpdate(String no) {
		
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/memberProfileImg/";
		
		List<ProjectUpdateVo> voList = dao.projectDetailUpdate(sst, no);
		for (ProjectUpdateVo vo : voList) {
			vo.setMemberPic(localAddr + path + vo.getMemberPic());
		}
		
		//프로젝트 업데이트 수 + 커뮤니티 수 + 창작자 번호
		ProjectDetailCntVo detailCntVo = dao.projectCnt(sst, no);
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("voList", voList);
		map.put("detailCntVo", detailCntVo);
		
		return map;
	}

	//프로젝트 상세 조회 - 커뮤니티
	public Map<String, Object> projectDetailCommunity(String no) {
		
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/memberProfileImg/";
		
		List<ProjectCommunityVo>voList = dao.projectDetailCommunity(sst, no);
		for (ProjectCommunityVo vo : voList) {
			vo.setMemberPic(localAddr + path + vo.getMemberPic());
			vo.setReplyerPic(localAddr + path + vo.getReplyerPic());
		}
		
		//프로젝트 업데이트 수 + 커뮤니티 수 + 창작자 번호
		ProjectDetailCntVo detailCntVo = dao.projectCnt(sst, no);
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("voList", voList);
		map.put("detailCntVo", detailCntVo);
		
		
		return map;
	}
	
	///////////////////////////////////////////////////////////////////////

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
