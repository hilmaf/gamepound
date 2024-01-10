package com.gamepound.app.back.vo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class BackVo {

	// 후원번호
	private String backNo;
	
	// 프로젝트 정보
	private String projectNo;
	private String projectTitle;
	private String projectImg;
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
	private String memberEmail; // sessionStorage 통해서 가져올 것
	
	// 결제 수단
	private String paymentTypeNo;
	private String paymentType;
	private String paymentDate;
	private String paymentAmount; // == 최종 후원 금액
	private String paymentStatus;
	
}
