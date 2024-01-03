package com.gamepound.app.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gamepound.app.back.service.BackServiceLKM;
import com.gamepound.app.back.vo.BackVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

@RequestMapping("back")
public class BackControllerLKM {
	
	private final BackServiceLKM service;	
	
	/**
	 * - 후원정보 테이블에 INSERT
	 * - 정기결제 등록
	 * - 결제일에 결제 성공 및 실패 시 그에 따라 결제 상태 update
	 * - 결제 실패 시 +7일 후 결제 요청 다시 하게끔 로직 설정
	 */
	// 후원하기
	@PostMapping("process")
	public void back(BackVo vo) throws Exception {
		int result = service.back(vo);
		
		if(result != 1) {
			System.out.println("후원 실패");
			throw new Exception();
		}
		
		System.out.println(result);
		System.out.println("후원 완료");
	}
	
	// 후원 완료
	@GetMapping("completed")
	public void completed(String projectNo) {
		
		String nthBacker = service.cntBacker(projectNo);
		
		System.out.println(nthBacker);
	}
	
	// 후원 취소
	@PostMapping("canceled")
	public void cancel(String backNo) {
		int result = service.cancel(backNo);
	
		System.out.println(result);
	}
}
