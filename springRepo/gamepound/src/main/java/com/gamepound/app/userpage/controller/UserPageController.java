package com.gamepound.app.userpage.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.review.vo.ReviewVo;
import com.gamepound.app.userpage.service.UserPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("userpage")
@CrossOrigin("*")
public class UserPageController {
	
	private final UserPageService service;
	
	// 유저페이지 - 리뷰목록, 리뷰 통계 조회
	@GetMapping("review")
	public void listReview(String memberNo) {
		
		Map<String, Object> map = service.listReview(memberNo);
		
		System.out.println(map);
	}
	
	// 리뷰 작성하기
	@PostMapping("review/write")
	public void write(ReviewVo vo) throws Exception {
		// service
		int result = service.write(vo);
		
		if(result != 1) {
			throw new Exception("후기 작성 실패...");
		}
		
		System.out.println(result);
	}
	
	// 유저페이지 - 내가 올린 프로젝트 목록 조회
	@GetMapping("created")
	public Map<String, Object> listMyProjects(String memberNo) {
		
		memberNo = "1";
		
		Map<String, Object> listMap = service.listMyProjects(memberNo);
		
		return listMap;
	}
	
	// 유저페이지 - 내 후원 목록 조회
	@GetMapping("backed")
	public void listMyBackedProjects(String memberNo) {
		Map<String, Object> map = service.listMyBackedProjects(memberNo);
		
		System.out.println(map);
	}
}
