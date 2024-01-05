package com.gamepound.app.payment.controller;

import org.springframework.stereotype.Controller;

import com.gamepound.app.payment.service.PaymentServiceLKM;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PaymentControllerLKM {
	
	private final PaymentServiceLKM service;
	
	
}
