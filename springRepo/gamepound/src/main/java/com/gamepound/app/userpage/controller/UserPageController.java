package com.gamepound.app.userpage.controller;

import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	// 유저페이지 - 프로필
	@GetMapping("")
	public ResponseEntity<String> userProfile(@RequestParam("user") String memberNo) {
		String profile = service.userProfile(memberNo);
		
		HttpHeaders header = getHttpHeaders("String");
		
		try {
			if(profile!=null) {
				return ResponseEntity.ok().headers(header).body(profile);
			} else {
				return ResponseEntity.notFound().headers(header).build();
			}
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(header).body("서버 내부 에러 500");
		}
	}
	
	// 유저페이지 - 리뷰목록, 리뷰 통계 조회
	@GetMapping("review")
	public Map<String, Object> listReview(@RequestParam("user") String memberNo) {
		
		Map<String, Object> map = service.listReview(memberNo);
		
		return map;
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
	public Map<String, Object> listMyProjects(@RequestParam("user") String memberNo) {
		Map<String, Object> listMap = service.listMyProjects(memberNo);
		
		return listMap;
	}
	
	// 유저페이지 - 내 후원 목록 조회
	@GetMapping("backed")
	public Map<String, Object> listMyBackedProjects(@RequestParam("user") String memberNo) {
		Map<String, Object> map = service.listMyBackedProjects(memberNo);
		
		return map;
	}
	
	// HttpHeaders 세팅
	private HttpHeaders getHttpHeaders(String respType) {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", respType, Charset.forName("UTF-8")));;
		
		return header;
	}
}
