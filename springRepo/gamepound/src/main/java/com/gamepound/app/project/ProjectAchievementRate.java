package com.gamepound.app.project;

public class ProjectAchievementRate {
	
	//프로젝트 달성률
	static public String achievementRate(String goalAmount, String currentAmount) {
		ProjectAchievementRate par = new ProjectAchievementRate();
		
		// amount 가공
		int goalA = Integer.parseInt(par.processAmount(goalAmount));
		int currentA = Integer.parseInt(par.processAmount(currentAmount));
		
		// 달성률 계산
		int result = (currentA*100)/goalA;
		
		return Integer.toString(result);
	}
	
	// amount 문자열 가공
	private String processAmount(String amount) {
		return amount.replace(",", "");
	}
}
