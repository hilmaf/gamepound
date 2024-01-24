package com.gamepound.app.back.vo;

import lombok.Data;

@Data
public class AdminBackVo {
	
	//후원 프로젝트
	private String projectTitle;
	private String projectNo;
	private String startDate;
	private String endDate;
	private String calDate;
	private String status;
	
	//후원자
	private String backNo;
	private String memberNo;
	private String memberName;

	//후원 선물
	private String rewardName;
	private String rewardAmount;
	
	//후원 정보
	private String backingDate;
	private String paymentStatus;
	private String paymentType;
	
	//검색 후원기간
	private String termStart;
	private String termEnd;
}
