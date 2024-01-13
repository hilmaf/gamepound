package com.gamepound.app.back.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BackDetailVo {
	
	// 후원번호
	private String backNo;
	private String backingDate;
	
	// 프로젝트 정보
	private String projectNo;
	private String projectImg;
	private String projectTitle;
	private String projectStatus;
	
	// 카테고리 정보
	private String categoryNo;
	private String categoryName;
	private String subCategoryName;
	
	// 창작자 정보
	private String memberName;
	
	// 달성 정보
	private String currentAmount;
	private String goalAmount;
	private String achievementRate;
	
	// 기한 정보
	private String endDate;
	private String remainingPeriod;
	
	////////////////////////////////////////////////////////////////////
	
	// 선물 정보
	private String rewardNo;
	private String rewardName;
	private String rewardAmount;
	
	// 후원자 정보
	private String memberNo;
	private String memberEmail; // sessionStorage 통해서 가져올 것
	
	// 결제 수단
	private String paymentTypeNo;
	private String paymentType;
	private String paymentDate;
	private String paymentAmount; // == 최종 후원 금액
	private String paymentStatus;
	private String paymentDueDate; // 결제예정일
	
	// 카드 정보
	private String cardNo1;
	private String cardNo2;
	private String cardNo3;
	private String cardNo4;
	
	private String validThru1;
	private String validThru2;
	
	private String cardPwd;
	private String birthDate;
}
