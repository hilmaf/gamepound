package com.gamepound.app.review.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.review.service.ReviewServiceLKM;
import com.gamepound.app.review.vo.ReviewVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewControllerLKM {

	private final ReviewServiceLKM service;

	// 리뷰 작성하기
	@PostMapping("write")
	public void write(ReviewVo vo) throws Exception {
		// service
		int result = service.write(vo);
		
		if(result != 1) {
			throw new Exception("후기 작성 실패...");
		}
		
		System.out.println(result);
	}
}
