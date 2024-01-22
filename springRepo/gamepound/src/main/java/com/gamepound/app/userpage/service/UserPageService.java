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
import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.page.vo.PageVo;
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
	
	private String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
	private String url2 = "http://127.0.0.1:8889/gamepound/resources/images/memberProfileImg/";
	private String url3 = "http://127.0.0.1:8889/gamepound/resources/images/reviewImg/";
	
	// 유저페이지 - 프로필 소개
	public String userIntro (String memberNo) {
		return dao.userIntro(sst, memberNo);
	}
	
	// 유저페이지 - 리뷰 통계 조회
	public ReviewStatVo statReview(String memberNo) {
		ReviewStatVo statVo = dao.getStat(sst, memberNo);
		
		return statVo;
	}
	 
	
	// 유저페이지 - 리뷰목록
	public Map<String, Object> listReview(Map<String, String> map) {
		// 리뷰 개수
		String cnt = dao.userReviewCnt(sst, map.get("memberNo"));
		
		// PageVo 생성
		int listCount = Integer.parseInt(cnt);
		String currentPage_= map.get("currentPage");
		if(currentPage_ == null) {
			currentPage_ = "1";
		}
		
		int currentPage = Integer.parseInt(currentPage_);
		int pageLimit = 5;
		int boardLimit = 10;
		
		PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		// 리뷰 목록
		List<ReviewVo> reviewList = dao.listReview(sst, map.get("memberNo"), pvo);
		System.out.println(reviewList.size());
		
		
		// TODO: 만족도 DOUBLE 타입으로 변경하는 거 삭제하기 (더미데이터를 수정하는 방향으로)
		// 만족도 double 타입으로 변경해서 다시 셋팅하기
		
		if(reviewList.size() > 0) {
			for(ReviewVo vo : reviewList) {
				vo.setRating(util.castToDouble(vo.getRating()));
				vo.setProjectImg(url + vo.getProjectImg());
				vo.setProfileImg(url2 + vo.getProfileImg());
				vo.setReviewImg(url3 + vo.getReviewImg());
			}			
		}
		
		
		// map에 넣기
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("reviewList", reviewList);
		resultMap.put("size", cnt);
		
		return resultMap;
	}

	// 리뷰 작성
	public int write(ReviewVo vo) {	
		// TODO: review 파일명 변경
		
		
		return dao.write(sst, vo);
	}
	
	// 유저페이지 - 내가 올린 프로젝트 목록 조회
	public Map<String, Object> listMyProjects(String memberNo) {
		Map<String, Object> listMap = new HashMap<>();
		
		String cnt = dao.myProjectsCnt(sst, memberNo);
		
		List<ProjectBriefVo> myProjectList = dao.listMyProjects(sst, memberNo);
		
		// 달성률, 마감기한 d- setting
		for(ProjectBriefVo vo : myProjectList) {
			String achievementRate = null;
			if(vo.getGoalAmount() != null) {
				achievementRate = util.achievementRate(vo.getGoalAmount(), vo.getCurrentAmount());
			}
			String remainingPeriod = util.getRemainingPeriod(vo.getEndDate(), "yyyy년 MM월 dd일");
			
			vo.setAchievementRate(achievementRate);
			vo.setRemainingPeriod(remainingPeriod);
			vo.setProjectImg(url + vo.getProjectImg());
		}
		
		listMap.put("projectsCnt", cnt);
		listMap.put("myProjectsList", myProjectList);

		return listMap;
	}

	// 유저페이지 - 내 후원 목록 조회
	public Map<String, Object> listMyBackedProjects(String memberNo) {
		// 후원 성공 목록 : 프로젝트 펀딩 성공
		List<BackDetailVo> successList = dao.backedSuccessfully(sst, memberNo);
		
		String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
		for (BackDetailVo backDetailVo : successList) {
			backDetailVo.setProjectImg(url + backDetailVo.getProjectImg());
		}
		System.out.println(successList);
		// 후원 실패 목록 : 프로젝트 펀딩 실패 OR 후원 취소
		List<BackDetailVo> failList = dao.backedUnsuccessfully(sst, memberNo);
		for (BackDetailVo backDetailVo : failList) {
			backDetailVo.setProjectImg(url + backDetailVo.getProjectImg());
		}
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

	public ReviewVo viewMyReview(String reviewNo) {
		ReviewVo reviewVo = dao.viewMyReview(sst, reviewNo);
		
		String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
		reviewVo.setProjectImg(url + reviewVo.getProjectImg());
		
		return reviewVo;
	}

	// 유저페이지 - 프로필
	public MemberVo userProfile(String memberNo) {
		MemberVo vo = dao.userProfile(sst, memberNo);
		String url = "http://127.0.0.1:8889/gamepound/resources/images/memberProfileImg/";
		vo.setPic(url + vo.getPic());
		
		return vo;
	}

	
}
