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
