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
	
	// 유저페이지 - 리뷰목록, 리뷰 통계 조회
	@GetMapping("review")
	public void listReview(String memberNo) {
		
		Map<String, Object> map = service.listReview(memberNo);
		
		System.out.println(map);
	}
	
	// 유저페이지 - 내 프로젝트 목록 조회
	@GetMapping("project")
	public void listMyProjects(String memberNo) {
		
	}
	
	// 유저페이지 - 내 후원 목록 조회
	@GetMapping("backed")
	public void listMyBackedProjects(String memberNo) {
		
	}
}
