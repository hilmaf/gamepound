package com.gamepound.app.back.vo;

import lombok.Data;

@Data
public class AdminBackVo {
	private String backNo;
	private String memberNo;
	private String memberName;
	private String projectTitle;
	private String projectNo;
	private String startDate;
	private String endDate;
	private String calDate;
	private String status;
	private String rewardName;
	private String rewardAmount;
	private String backingDate;
	private String paymentStatus;
	private String paymentType;
}
