package com.gamepound.app.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.review.service.ReviewServiceLKM;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewControllerLKM {

	private final ReviewServiceLKM service;


	// 리뷰 작성하기
	
}
