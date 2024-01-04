package com.gamepound.app.back.vo;

import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.ProjectRemainingPeriod;

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
	private String backingDate;

	// 선물 정보
	private String rewardNo;
	private String rewardName;
	private String rewardAmount;
	
	// 후원자 정보
	private String memberNo;
	private String memberEmail;
	
	// 결제 수단
	private String paymentType;
	private String paymentDate;
	private String paymentAmount; // == 최종 후원 금액
	private String paymentStatus;
	
	
	// 달성률 getter
	public String getAchievedRate() {
		return ProjectAchievementRate.achievementRate(this.goalAmount, this.currentAmount);
	}
	
	// 마감기한 getter
	public String getRemainingPeriod() {
		return ProjectRemainingPeriod.getRemainingPeriod(this.endDate);
	}
	
}
