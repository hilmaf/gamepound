package com.gamepound.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
@Configuration
public class DataProcessingUtil {
		
	ProcessSupport support = new ProcessSupport();
	
	// 달성률 계산
	public String achievementRate(String goalAmount, String currentAmount) {
		
		// amount 가공
		int goalA = Integer.parseInt(support.removeCommas(goalAmount));
		int currentA = Integer.parseInt(support.removeCommas(currentAmount));
		
		// 달성률 계산
		int result = (currentA*100)/goalA;
		
		return Integer.toString(result);
	}
	
	// 마감기한 D-day 계산
	public String getRemainingPeriod(String endDate, String format) {
		// 마감일, sysdate 간 차이
		Date currentDate = new Date();
		Date parsedEndDate = support.parseDate(endDate, format);
		
		if(currentDate.compareTo(parsedEndDate) >= 0) {
			return "펀딩 종료";
		} else {
			Calendar currentCalendar = Calendar.getInstance();
			Calendar endDateCalendar = Calendar.getInstance();
			currentCalendar.setTime(currentDate);
			endDateCalendar.setTime(parsedEndDate);
			
			long gap = (endDateCalendar.getTimeInMillis() - currentCalendar.getTimeInMillis()) / (24*60*60*1000);
			
			// gap 절대값
			long absoluteGap_ = Math.abs(gap);
			System.out.println("absoluteGap :: " + absoluteGap_);
			
			String absoluteGap = String.valueOf(absoluteGap_);
			
			return absoluteGap;			
		}
	}
	
	// 결제일 계산
	public String calcPaymentDueDate(String endDate, String format) {
		
		Date parsedEndDate = support.parseDate(endDate, format);
		
		// Calnedar 객체에 펀딩종료일 셋팅
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parsedEndDate);
		
		// 날짜 +1일 연산
		calendar.add(Calendar.DATE, 1);
		
		// String타입으로 변환
		String paymentDueDate = support.transformDateToString(new Date(calendar.getTimeInMillis()));
		
		return paymentDueDate;
	}
	
	

	
	class ProcessSupport {
		
		// amount 문자열 가공
		String removeCommas(String goalAmount) {
			return goalAmount.replace(",", "");
		}
		
		// endDate 가공
		Date parseDate(String endDate, String format) {

			Date parsedEndDate = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat(format);
				parsedEndDate = dateFormat.parse(endDate);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return parsedEndDate;
		}
		
		// Date 타입 변수 날짜 형식에 알맞게 String으로 가공
		String transformDateToString(Date date) {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
			String dateStr = dateFormat.format(date);
			
			return dateStr;
		}
	}
	
}
