package com.gamepound.app.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectRemainingPeriod {
	
	// 마감기한으로부터 D-
	public static String getRemainingPeriod(String endDate) {
		String diff = null;
	    try {
	    	// 날짜 객체
	    	String format = "yyyy년 MM월 dd일";
	    	DateFormat df = new SimpleDateFormat(format);
	    	
	    	// endDate 가공
	    	String endDate_ = endDate.substring(0, format.length());
	    	
	    	// 마감일, sysdate 간 차이
	    	Date currentDate = new Date();
		    Date parsedEndDate = df.parse(endDate_);
		    
		    // int 형변환 이전에 반올림
		    int gap = (int) Math.round((parsedEndDate.getTime() - currentDate.getTime()) / (24*60*60*1000));
		    // gap 절대값
		    int absoluteGap = Math.abs(gap);
		    
		    diff = String.valueOf(absoluteGap);
		    
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return diff;
	}
	
}
