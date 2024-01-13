package com.gamepound.app.userpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.ProjectRemainingPeriod;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;
import com.gamepound.app.userpage.dao.UserPageDao;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserPageService {

	private final SqlSessionTemplate sst;
	private final UserPageDao dao;
	private final DataProcessingUtil util;
	
	// 유저페이지 - 프로필 소개
	public String userProfile(String memberNo) {
		return dao.userProfile(sst, memberNo);
	}
	
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
		
		System.out.println(reviewList);
		
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
		for(ProjectBriefVo vo : myProjectList) {
			String achievementRate = util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount());
			String remainingPeriod = util.getRemainingPeriod(vo.getEndDate(), "YYYY년 MM월 DD일");
			
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
		List<BackDetailVo> successList = dao.backedSuccessfully(sst, memberNo);
		System.out.println(successList);
		// 후원 실패 목록 : 프로젝트 펀딩 실패 OR 후원 취소
		List<BackDetailVo> failList = dao.backedUnsuccessfully(sst, memberNo);
		System.out.println(failList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successList", successList);
		map.put("failList", failList);
		map.put("successCnt", successList.size());
		map.put("failCnt", failList.size());
		map.put("cnt", successList.size() + failList.size());
		
		return map;
	}
	
	 
}
