package com.gamepound.app.back.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("back")
@CrossOrigin("*")
@Slf4j
public class BackControllerLKM {
	
	private final BackServiceLKM service;	
	
	// 후원하기(화면)
	@GetMapping("process")
	public BackVo viewBackPage(BackVo backVo) throws Exception {
		BackVo bvo = service.viewBackingPage(backVo);
		return bvo;
	}
	
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
		return map;
	}
	
	// 후원 완료(화면)
	@GetMapping("completed")
	public ResponseEntity<String> completed(@RequestParam("no") String projectNo) {
		// 몇번째 후원
		String nthBacker = service.cntBacker(projectNo);
		
		HttpHeaders header = getHttpHeaders("String");
		
		try {
			if(nthBacker!=null) {
				return ResponseEntity.ok().headers(header).body(nthBacker);
			} else {
				return ResponseEntity.notFound().headers(header).build();
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(header).body("서버 내부 에러 500");
		}
	}
	
	// 후원 취소
	@PostMapping("canceled")
	public Map<String, String> cancel(@RequestBody BackVo backVo) throws Exception {
		boolean canceled = service.cancel(backVo.getBackNo());
	
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
	
	// HttpHeaders 세팅
	private HttpHeaders getHttpHeaders(String respType) {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", respType, Charset.forName("UTF-8")));;
		
		return header;
	}
}
