package com.gamepound.app.review.vo;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ReviewStatVo {

	private String cntReview; // 리뷰 전체 cnt
	private String ratingAvg; // 만족도 평균
	private List<String> ratingCntList; // 만족도 cnt (분포)
	
}
