package com.gamepound.app.payment.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.payment.service.PaymentServiceLKM;
import com.gamepound.app.payment.vo.PaymentVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("pay")
public class PaymentControllerLKM {
	
	private final PaymentServiceLKM service;
	
	// 결제하기
	@Scheduled(cron = "0 0 0 * * *")
	@PostMapping("")
	public void pay(PaymentVo vo) {
		
//		service.pay(vo);
		
	}
}
