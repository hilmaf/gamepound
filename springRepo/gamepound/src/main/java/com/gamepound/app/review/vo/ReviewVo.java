package com.gamepound.app.review.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ReviewVo {

	// 리뷰
	private String reviewNo;
	private String reviewContent;
	private String reviewImg;
	private String rating;
	private String enrollDate;
	
	// 후원 정보
	private String backNo;
	
	// 작성자
	private String memberNo;
	private String memberName;
	private String profileImg;
	
	// 프로젝트 정보
	private String projectNo;
	private String projectTitle;
	private String projectImg;
	
}
