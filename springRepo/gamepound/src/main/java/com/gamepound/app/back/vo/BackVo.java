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

	// 프로젝트 정보
	private String projectNo;
	private String projectImg;
	private String projectCategory;
	private String projectSubCategory;
	private String projectName;
	private String goalAmount;
	private String currentAmount;
	// 달성률
	private String achievedRate;
	// 마감기한까지 D-N
	private String endDate;
	private String remainPeriod;
	
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
	
	
	// TODO : 마감기한까지 n일
	public String getRemainPeriod(String endDate) {
	    try {
	    	DateFormat df = new SimpleDateFormat("yy/mm/dd HH:mm:ss");
		    Date date = df.parse(endDate);
		    long timeStamp = date.getTime();
		    Timestamp endDate_ = new Timestamp(timeStamp);
		    
		    System.out.println(endDate);
		    
		    Date currentDate = new Date();
	    } catch(Exception e) {
	    	
	    }
		return "";
	}
	
}
