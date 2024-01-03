package com.gamepound.app.project;

public class ProjectAchievementRate {
	
	//프로젝트 달성률
	static public String achievementRate(String goalAmount, String currentAmount) {
		int goalA = Integer.parseInt(goalAmount);
		int currentA = Integer.parseInt(currentAmount);
		int result = (currentA*100)/goalA;
		
		return Integer.toString(result);
	}
}
