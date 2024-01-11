package com.gamepound.app.userpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.vo.BackVo;
import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.ProjectRemainingPeriod;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;
import com.gamepound.app.userpage.dao.UserPageDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserPageService {

	private final SqlSessionTemplate sst;
	private final UserPageDao dao;
	
	// 유저페이지 - 리뷰목록, 리뷰 통계 조회
	public Map<String, Object> listReview(String memberNo) {
		// 리뷰 목록
		List<ReviewVo> reviewList = dao.listReview(sst, memberNo);
		// 리뷰 통계
		ReviewStatVo statVo = dao.getStat(sst, memberNo);
		
		// map에 넣기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewList", reviewList);
		map.put("statVo", statVo);
		
		return map;
	}

	// 리뷰 작성
	public int write(ReviewVo vo) {	
		return dao.write(sst, vo);
	}
	
	// 유저페이지 - 내가 올린 프로젝트 목록 조회
	public Map<String, Object> listMyProjects(String memberNo) {
		Map<String, Object> listMap = new HashMap<>();
		
		String cnt = dao.myProjectsCnt(sst, memberNo);
		
		List<ProjectBriefVo> myProjectList = dao.listMyProjects(sst, memberNo);
		
		// 달성률, 마감기한 d- setting
		// TODO: 성능 개선
		for(ProjectBriefVo vo : myProjectList) {
			String achievementRate = ProjectAchievementRate.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount());
			String remainingPeriod = ProjectRemainingPeriod.getRemainingPeriod(vo.getEndDate());
			vo.setAchievementRate(achievementRate);
			vo.setRemainingPeriod(remainingPeriod);
		}
		
		listMap.put("projectsCnt", cnt);
		listMap.put("myProjectsList", myProjectList);

		return listMap;
	}

	// 유저페이지 - 내 후원 목록 조회
	public Map<String, Object> listMyBackedProjects(String memberNo) {
		// 후원 성공 목록 : 프로젝트 펀딩 성공
		List<BackVo> successList = dao.backedSuccessfully(sst, memberNo);
		// 후원 실패 목록 : 프로젝트 펀딩 실패 OR 후원 취소
		List<BackVo> failList = dao.backedUnsuccessfully(sst, memberNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successList", successList);
		map.put("failList", failList);
		
		return map;
	}
	
	 
}
