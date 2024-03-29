package com.gamepound.app.userpage.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.page.vo.PageVo;
import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;
import com.gamepound.app.userpage.service.UserPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("userpage")
public class UserPageController {
	
	private final UserPageService service;
	
	
	// 유저페이지 - 프로필
	@GetMapping("profile")
	public MemberVo userProfile(String memberNo) {
		MemberVo vo = service.userProfile(memberNo);
		
		return vo;
	}
	
	// 유저페이지 - 인트로
	@GetMapping("")
	public ResponseEntity<String> userIntro(@RequestParam("user") String memberNo) {
		String profile = service.userIntro(memberNo);
		
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
	
	// 유저페이지 - 리뷰목록 조회
	@PostMapping("review")
	public Map<String, Object> listReview(@RequestBody Map<String, String> map) {
		System.out.println(map);
		Map<String, Object> resultMap = service.listReview(map);
		System.out.println(resultMap);
		return resultMap;
	}
	
	// 유저페이지 - 리뷰통계 조회
	@PostMapping("review/stat")
	public ReviewStatVo statReview(@RequestBody Map<String, String> memberMap) {
		System.out.println("review통계 조회");
		
		ReviewStatVo statVo = service.statReview(memberMap.get("memberNo"));
		
		return statVo;
		
	}
	
	// 리뷰 작성하기
	@PostMapping("review/write")
	public Map<String, String> write(@RequestParam("backNo") String backNo,
			@RequestParam("memberNo") String memberNo,
			@RequestParam("rating") String rating,
			@RequestParam("reviewContent") String reviewContent, 
			@RequestPart(name="reviewImg", required=false) MultipartFile reviewImg, HttpServletRequest req) throws Exception {
		
		// TODO: 이미 해당 후원목록에 대해 후기를 작성했으면, 다시 후기 작성 불가능함
		// vo에 담아주기
		ReviewVo vo = new ReviewVo();
		vo.setBackNo(backNo);
		vo.setMemberNo(memberNo);
		vo.setRating(rating);
		vo.setReviewContent(reviewContent);
		
		// 파일명 설정
		String uploadDir = "/resources/images/reviewImg/";
		String root = req.getServletContext().getRealPath(uploadDir); // 저장경로
		String fileName = null;
		if(!(reviewImg==null) && !(reviewImg.isEmpty())) {
			fileName = service.imagefileSave(reviewImg, root);
		}
		
		vo.setReviewImg(fileName);
		
		// service
		int result = service.write(vo);
		
		Map<String, String> map = new HashMap<>();
	    map.put("msg", "good");
	    if(result != 1) {
	       map.put("msg", "bad");
	    }
	      
	    return map;

	}
	
	// 내 리뷰 조회
	@GetMapping("backed/review")
	public ReviewVo viewMyReview(@RequestParam String reviewNo) {
		ReviewVo reviewVo = service.viewMyReview(reviewNo);
		return reviewVo;
	}
	
	// 유저페이지 - 내가 올린 프로젝트 목록 조회
	@GetMapping("created")
	public Map<String, Object> listMyProjects(@RequestParam("user") String memberNo
											, @RequestParam("yn") String matchYn) {
		Map<String, Object> map = new HashMap<>();
		map.put("user", memberNo);
		map.put("yn", matchYn);
		Map<String, Object> listMap = service.listMyProjects(map);
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
