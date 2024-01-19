package com.gamepound.app.project.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ProjectBriefVo {

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
	private String startDate;
	private String endDate;
	private String remainingPeriod;
	
}
