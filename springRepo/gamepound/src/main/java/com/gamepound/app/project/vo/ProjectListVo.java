package com.gamepound.app.project.vo;

import lombok.Data;

@Data
public class ProjectListVo {
	private String query;
	private String categoryNo;
	
	// selectTag에서 받아오는 값
	private String status;
	private String achievementRate;
	
	// DB에 넣기 위해 변환한 값
	private String statusNo;
	private String achievementRateStart;
	private String achievementRateEnd;
}
