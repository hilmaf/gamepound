package com.gamepound.app.back.vo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class BackVo {

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
	private String goalAmount;
	private String currentAmount;
	private String achievementRate;
	
	private String endDate;
	private String remainingPeriod;
	
	// 후원 정보
	private String backNo;
	private String backDate;

	// 선물 정보
	private String rewardNo;
	private String rewardName;
	private String rewardAmount;
	
	// 후원자 정보
	private String memberNo;
	private String memberEmail;
	
	// 결제예정일
	private String paymentDueDate;
		
}
