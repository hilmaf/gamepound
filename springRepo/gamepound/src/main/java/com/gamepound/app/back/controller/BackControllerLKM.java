package com.gamepound.app.back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.back.service.BackServiceLKM;
import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("back")
@CrossOrigin("*")
public class BackControllerLKM {
	
	private final BackServiceLKM service;	
	
	// 후원하기(화면)
	@GetMapping("process")
	public BackVo viewBackPage(BackVo backVo) throws Exception {
		
		// 임의로 정보 세팅(임시) TODO: 정보세팅 지우기
		backVo.setProjectNo("1");
		backVo.setRewardNo("1");
		
		BackVo bvo = service.viewBackingPage(backVo);
		System.out.println(bvo);
		return bvo;
	}
	
	/**
	 * - 후원정보 테이블에 INSERT
	 * - 정기결제 등록
	 * - 결제일에 결제 성공 및 실패 시 그에 따라 결제 상태 update
	 * - 결제 실패 시 +7일 후 결제 요청 다시 하게끔 로직 설정
	 */	
	// 후원하기
	@PostMapping("process")
	public Map<String, String> back(@RequestBody BackDetailVo vo) throws Exception {
		
		boolean backed = service.back(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(backed == false) {
			map.put("result", "fail");
			throw new Exception();
		}
		
		map.put("result", "success");
		System.out.println(1);
		return map;
	}
	
	// 후원 완료(화면)
	@GetMapping("completed")
	public String completed(String projectNo) {
		
		projectNo = "1";
		
		String nthBacker = service.cntBacker(projectNo);
		
		return nthBacker;
	}
	
	// 후원 취소
	@PostMapping("canceled")
	public Map<String, String> cancel(String backNo) throws Exception {
		boolean canceled = service.cancel(backNo);
	
		Map<String, String> map = new HashMap<>();
		
		if(canceled==false) {
			map.put("msg", "fail");
			throw new Exception();
		}
		
		map.put("msg", "canceled");
		
		return map;
	}
	
	// 후원 상세 조회
	@GetMapping("detail")
	public BackDetailVo detail(@RequestParam("no") String backNo) {
		BackDetailVo vo = service.detail(backNo);
		
		return vo;
		
		
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
