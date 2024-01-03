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
	    	DateFormat df = new SimpleDateFormat("yy/MM/dd");
	    	
	    	// 마감일, sysdate 간 차이
	    	Date currentDate = new Date();
		    Date endDate_ = df.parse(endDate);
		    
		    diff = Integer.toString((int) ((endDate_.getTime() - currentDate.getTime()) / (24*60*60*1000)));
		    
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    return diff;
	}
	
}
