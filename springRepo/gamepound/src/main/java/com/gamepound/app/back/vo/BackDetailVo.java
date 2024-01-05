package com.gamepound.app.back.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BackDetailVo {

	// 프로젝트 정보
	private String projectNo;
	private String projectImg;
	private String projectCategory;
	private String projectSubCategory;
	private String projectName;
	private String goalAmount;
	private String currentAmount;
	private String endDate;
	
	// 후원 정보
	private String backNo;
	private String backingDate;

	// 선물 정보
	private String rewardNo;
	private String rewardName;
	private String rewardAmount;
	
	// 후원자 정보
	private String memberNo;
	private String memberEmail;
	
	// 결제 수단
	private String paymentTypeNo;
	private String paymentType;
	private String paymentDate;
	private String paymentAmount; // == 최종 후원 금액
	private String paymentStatus;
	
}
