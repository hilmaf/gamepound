package com.gamepound.app.project.vo;

import lombok.Data;

@Data
public class ProjectVo {
	//프로젝트 상태
	private String statusNo;
	private String statusName;
	
	//프로젝트 카테고리
	private String categoryNo;
	private String mainCategoryNo;	//대분류번호
	private String mainCategory;	//대분류
	private String subCategoryNo;	//소분류번호
	private String subCategory;		//소분류
	
	//프로젝트 작성자
	private String memberNo;
	private String memberName;

	//프로젝트 내용
	private String no;
	private String title;
	private String goalAmount;		//999,999,999
	private String goalAmountNo;	//999999999
	private String currentAmount;	//999,999,999
	private String currentAmountNo;	//999999999
	private String imageUrl;
	private String txtDescription;
	private String txtBudget;
	private String txtSchedule;
	private String txtTeam;
	private String txtItem;
	
	//프로젝트 기간
	private String okDate;
	private String enrollDate;
	private String startDate;
	private String endDate;
	private String calDate;
	
	//프로젝트 승인*삭제 여부
	private String okYn;
	private String deleteYn;
	
	//프로젝트 달성률
	private String achievementRate;
	
	//프로젝트 남은 기간
	private String remainingPeriod;
	
}
