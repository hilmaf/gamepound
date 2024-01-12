package com.gamepound.app.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectRemainingPeriod implements ProjectDataTransformation {
	
	// 마감기한으로부터 D-
	@Override
	public String transform(String endDate, String format) {
		String absoluteGap = null;
		try {
			// 날짜 객체 얻기
			DateFormat dateFormat = new SimpleDateFormat(format);
			
			// endDate 가공
			String endDate_ = endDate.substring(0, format.length());
			
			// 마감일, sysdate 간 차이
			Date currentDate = new Date();
			Date parsedEndDate = dateFormat.parse(endDate_);
			
			// int 형변환 이전에 반올림
			int gap = (int) Math.round((parsedEndDate.getTime() - currentDate.getTime()) / (24*60*60*1000));
			// gap 절대값
			int absoluteGap_ = Math.abs(gap);
			
			absoluteGap = String.valueOf(absoluteGap_);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return absoluteGap;
	}
	
	public static String getRemainingPeriod(String endDate) {
		String absoluteGap = null;
		try {
			
			String format = "yyyy년 MM월 dd일";
			
			// 날짜 객체 얻기
			DateFormat dateFormat = new SimpleDateFormat(format);
			
			// endDate 가공
			String endDate_ = endDate.substring(0, format.length());
			
			// 마감일, sysdate 간 차이
			Date currentDate = new Date();
			Date parsedEndDate = dateFormat.parse(endDate_);
			
			// int 형변환 이전에 반올림
			int gap = (int) Math.round((parsedEndDate.getTime() - currentDate.getTime()) / (24*60*60*1000));
			// gap 절대값
			int absoluteGap_ = Math.abs(gap);
			
			absoluteGap = String.valueOf(absoluteGap_);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return absoluteGap;
	}
	
}
