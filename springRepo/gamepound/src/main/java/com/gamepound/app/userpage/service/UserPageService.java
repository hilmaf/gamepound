package com.gamepound.app.userpage.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gamepound.app.back.vo.BackDetailVo;
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
		System.out.println(reviewList);
		
		// 만족도 double 타입으로 변경해서 다시 셋팅하기
		for(ReviewVo vo : reviewList) {
			vo.setRating(util.castToDouble(vo.getRating()));
		}
		
		// 리뷰 통계
		ReviewStatVo statVo = dao.getStat(sst, memberNo);
		
		// 만족도 평균 double 타입으로 변경
		statVo.setRatingAvg(util.castToDouble(statVo.getRatingAvg()));
		
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
		
		System.out.println("myProjectList ::: " + myProjectList);
		// 달성률, 마감기한 d- setting
		for(ProjectBriefVo vo : myProjectList) {
			String achievementRate = util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount());
			String remainingPeriod = util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일");
			
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

	// 서버에 이미지 파일 업로드
	public String imagefileSave(MultipartFile reviewImg, String root) throws Exception {
		// 랜덤파일이름 생성
		String fileName = reviewImg.getOriginalFilename();
		String fileExtension = fileName.substring(fileName.lastIndexOf('.'));
		
		// 랜덤 파일명 생성
		UUID uuid = UUID.randomUUID();
		fileName = uuid.toString() + fileExtension;
		
		// 이미지 webapp/resources/images/reviewImg 경로에 저장
		String filePath = root + fileName;
		File dest = new File(filePath);
		reviewImg.transferTo(dest);
		
		return fileName;
	}

	
	 
}
