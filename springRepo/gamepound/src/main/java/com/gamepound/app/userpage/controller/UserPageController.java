package com.gamepound.app.userpage.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.review.vo.ReviewVo;
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
	@GetMapping("project")
	public void listMyProjects(String memberNo) {
		List<ProjectVo> myProjectList = service.listMyProjects(memberNo);
		
		System.out.println(myProjectList);
	}
	
	// 유저페이지 - 내 후원 목록 조회
	@GetMapping("backed")
	public void listMyBackedProjects(String memberNo) {
		
	}
}
