package com.gamepound.app.payment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.payment.service.AdminPaymentServiceHJY;
import com.gamepound.app.payment.vo.PaymentStatusVo;
import com.gamepound.app.payment.vo.PaymentVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("admin/payment")
@RequiredArgsConstructor
@RestController
public class AdminPaymentControllerHJY {
	
	private final AdminPaymentServiceHJY service;
	
	// 전체 조회하기
	@GetMapping("list")
	public Map<String, Object> getPaymentList(String pageNum) {
		log.info("getPaymentLis 시작 ");
		Map<String, Object> map = service.getPaymentList(pageNum);
		log.info("getPaymentLis 종료 : {}", map);
		
		return map;
	}
	
	// 검색 조회하기
	@PostMapping("search/list")
	public Map<String, Object> getPaymentSearchList(@RequestBody Map<String, String> vo) {
		log.info("getPaymentSearchList 시작, {} ", vo);
		Map<String, Object> map = service.getPaymentSearchList(vo);
		log.info("getPaymentSearchList 종료 : {}", map);
		
		return map;
	}
	
	// 결제 상태 리스트 가져오기
	@GetMapping("status")
	public List<PaymentStatusVo> getPaymentStatus() {
		return service.getPaymentStatus();
	}
	
}
