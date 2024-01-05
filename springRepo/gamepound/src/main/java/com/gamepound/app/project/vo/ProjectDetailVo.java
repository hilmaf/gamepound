package com.gamepound.app.project.vo;

import java.util.List;

import com.gamepound.app.reward.vo.RewardVo;

import lombok.Data;

@Data
public class ProjectDetailVo {
	//프로젝트 상태
	private String statusNo;
	private String statusName;
	
	//프로젝트 카테고리
	private String categoryNo;
	private String mainCategory;	//대분류
	private String subCategory;		//소분류
	
	//프로젝트 작성자
	private String memberNo;
	private String memberName;

	//프로젝트 내용
	private String no;
	private String title;
	private String imageUrl;
	private String goalAmount;
	private String currentAmount;
	
	//프로젝트 기간
	private String okDate;
	private String enrollDate;
	private String startDate;
	private String endDate;
	private String calDate;
	
	//프로젝트 승인*삭제 여부
	private String okYn;
	private String deleteYn;
	
	//프로젝트 선물
	private List<RewardVo> rewardVo;
	
}
