package com.gamepound.app.project.vo;

import java.util.List;

import com.gamepound.app.reward.vo.RewardVo;
import com.gamepound.app.reward.vo.RewardVoLKM;

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
	private String memberPic;
	private String memberIntro;

	//프로젝트 내용
	private String no;
	private String title;
	private String imageUrl;
	private String goalAmount;
	private String currentAmount;
	private String achievementRate;	//%
	private String remainingPeriod;	//남은 시간
	private String totalBackerNo;	//후원자 수
	
	//프로젝트 기간
	private String okDate;
	private String enrollDate;
	private String startDate;		//YYYY년 MM월 DD일 표기
	private String startDateStr;	//YYYY.MM.DD 표기
	private String endDate;			//YYYY년 MM월 DD일 표기
	private String endDateStr;		//YYYY.MM.DD표기
	private String calDate;
	
	//프로젝트 승인*삭제 여부
	private String okYn;
	private String deleteYn;
	
	//프로젝트 선물
	private List<RewardVo> rewardVoList;
	private List<RewardVoLKM> rewardList;
	// rewardList에 담기 위한 필드
	private String rewardNo;
	private String rewardAmount;
	private String rewardName;
	
	//프로젝트 정산정보
	private String bankName;
	private String ownerName;
	private String accountNum;
	
}
