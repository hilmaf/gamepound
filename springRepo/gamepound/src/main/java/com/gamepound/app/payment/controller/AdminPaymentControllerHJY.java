package com.gamepound.app.payment.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.payment.service.AdminPaymentServiceHJY;

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
	@GetMapping("search/list")
	public void getPaymentSearchList() {
		
	}
	
}
