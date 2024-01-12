package com.gamepound.app.project;

public class ProjectAchievementRate implements ProjectDataTransformation {
	
	//프로젝트 달성률
	@Override
	public String transform(String goalAmount, String currentAmount) {
		int goalAmount_ = Integer.parseInt(removeCommas(goalAmount));
		int currentAmount_ = Integer.parseInt(removeCommas(currentAmount));
		
		// 달성률 계산
		int result = (currentAmount_*100)/goalAmount_;
		
		return Integer.toString(result);
	}
	
	static public String achievementRate(String goalAmount, String currentAmount) {
		ProjectAchievementRate par = new ProjectAchievementRate();
		
		// amount 가공
		int goalA = Integer.parseInt(par.removeCommas(goalAmount));
		int currentA = Integer.parseInt(par.removeCommas(currentAmount));
		
		// 달성률 계산
		int result = (currentA*100)/goalA;
		
		return Integer.toString(result);
	}
	
	// amount 문자열 가공
	private String removeCommas(String goalAmount) {
		return goalAmount.replace(",", "");
	}
}
