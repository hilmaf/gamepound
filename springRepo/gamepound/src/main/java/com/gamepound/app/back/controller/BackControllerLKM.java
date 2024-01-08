package com.gamepound.app.back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.back.service.BackServiceLKM;
import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;
import com.gamepound.app.project.vo.ProjectBriefVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("back")
@CrossOrigin("*")
public class BackControllerLKM {
	
	private final BackServiceLKM service;	
	
	/**
	 * - 후원정보 테이블에 INSERT
	 * - 정기결제 등록
	 * - 결제일에 결제 성공 및 실패 시 그에 따라 결제 상태 update
	 * - 결제 실패 시 +7일 후 결제 요청 다시 하게끔 로직 설정
	 */
	
	// 후원하기(화면)
	@GetMapping("process")
	public Map<String, Object> viewBackPage(ProjectBriefVo projectVo, BackVo backVo) throws Exception {
		
		// 임의로 정보 세팅(임시) TODO: 정보세팅 지우기
		projectVo.setProjectNo("1");
		projectVo.setProjectTitle("풀 메탈 퓨리즈 액션 어드벤처");
		projectVo.setCategoryName("비디오");
		projectVo.setSubCategoryName("RPG");
		projectVo.setAchievementAmnt("13950295");
		projectVo.setAchievementRate("2222");
		projectVo.setEndDate("2024-01-08");
		
		backVo.setMemberEmail("shicole@naver.com");
		backVo.setRewardName("스팀 제품 키");
		
		Map<String, Object> map = new HashMap<>();
		map.put("ProjectBriefVo", projectVo);
		map.put("BackVo", backVo);
		
		return map;
	}
	
	// 후원하기
	@PostMapping("process")
	public void back(BackDetailVo vo) throws Exception {
		boolean backed = service.back(vo);
		
		if(backed == false) {
			System.out.println("후원 실패");
			throw new Exception();
		}
		
		System.out.println(backed);
		System.out.println("후원 완료");
	}
	
	// 후원 완료(화면)
	@GetMapping("completed")
	public void completed(String projectNo) {
		
		String nthBacker = service.cntBacker(projectNo);
		
		System.out.println(nthBacker);
	}
	
	// 후원 취소
	@PostMapping("canceled")
	public void cancel(String backNo) throws Exception {
		boolean canceled = service.cancel(backNo);
	
		System.out.println(canceled);
	}
	
	// 후원 상세 조회
	@GetMapping("detail")
	public void detail(String backNo) {
		BackVo vo = service.detail(backNo);
		
	}
	
	// 후원 내용 변경 - 선물 변경
	@PostMapping("change/reward")
	public void changeReward(BackVo vo) {
		int result = service.changeReward(vo);
	}
	
	// 후원 내용 변경 - 결제 수단 변경
	@PostMapping("change/paymentType")
	public void changePaymentType(BackVo vo) {
		int result = service.changePaymentType(vo);
	}
}
