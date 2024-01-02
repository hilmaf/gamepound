package com.gamepound.app.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamepound.app.back.service.BackServiceLKM;
import com.gamepound.app.back.vo.BackVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class BackControllerLKM {
	
	private final BackServiceLKM service;	
	
	/**
	 * - 후원정보 테이블에 INSERT
	 * - 정기결제 등록
	 * - 결제일에 결제 성공 및 실패 시 그에 따라 결제 상태 update
	 * - 결제 실패 시 +7일 후 결제 요청 다시 하게끔 로직 설정
	 */
	// 후원하기
	@PostMapping("/back")
	public String back(BackVo vo) throws Exception {
		int result = service.back(vo);
		
		if(result != 1) {
			System.out.println("후원 실패");
			throw new Exception();
		}
		
		System.out.println("후원 완료");
		
		return "";
	}
	
	// 후원 예약
	
	// 후원 취소
	
}
