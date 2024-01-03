package com.gamepound.app.userpage.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.userpage.service.UserPageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("userpage")
public class UserPageController {
	
	private final UserPageService service;
	
	// 특정 창작자에게 달린 리뷰 목록 조회하기
	@GetMapping("review")
	public void listReview(String memberNo) {
		
		Map<String, Object> map = service.listReview(memberNo);
		
		System.out.println(map);
	}
	
	@GetMapping("backed")
	public void listBacked(String memberNo) {
		
	}
	
	
}
