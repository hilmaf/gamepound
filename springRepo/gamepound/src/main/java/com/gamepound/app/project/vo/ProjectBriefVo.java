package com.gamepound.app.project.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class ProjectBriefVo {

	private String projectNo;
	private String projectTitle;
	private String projectImg;
	private String categoryNo;
	private String categoryName;
	private String subCategoryName;
	private String achievementAmnt;
	private String achievementRate;
	private String endDate;
	private String remainingPeriod;
	
}
