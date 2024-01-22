package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoLKM;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceLKM {

	private final SqlSessionTemplate sst;
	private final ProjectDaoLKM dao;
	private final DataProcessingUtil util;
	
	// 프로젝트 검색
	public List<ProjectBriefVo> searchProject(ProjectListVo vo) {
		
		String transformedStatus = transformStatus(vo.getStatus());
		vo.setStatusNo(transformedStatus);
		
		String[] scales = transformAchievementRate(vo.getAchievementRate());
		vo.setAchievementRateStart(scales[0]);
		vo.setAchievementRateEnd(scales[1]);
		
		List<ProjectBriefVo> searchedList = dao.searchProject(sst, vo);
		
		String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
		
		for (ProjectBriefVo projectVo : searchedList) {
			projectVo.setProjectImg(url + projectVo.getProjectImg());
			String achievementRate = util.achievementRate(projectVo.getGoalAmount(), projectVo.getCurrentAmount());
			projectVo.setAchievementRate(achievementRate);
		}
		
		System.out.println(searchedList);
		
		return searchedList;
	}
	
	private String transformStatus(String status) {
		
		String statusNo = null;
		
		if(status == null) {
			return "";
		}
		
		switch(status) {
		case "all": statusNo = ""; break;
		case "ing": statusNo = "5"; break;
		case "success": statusNo = "6"; break;
		case "prelaunch": statusNo = "3"; break;
		}
		
		return statusNo;
	}
	
	private String[] transformAchievementRate(String achievementRate) {
		
		String achievementRateStart = null;
		String achievementRateEnd = null;
		
		if(achievementRate == null) {
			String[] scales = {"", ""};
			return scales;
		}
		
		switch(achievementRate) {
		case "all": achievementRateStart = "";
					achievementRateEnd = ""; break;
		case "under75": achievementRateStart = "";
						achievementRateEnd = "75"; break;
		case "between": achievementRateStart = "75";
						achievementRateEnd = "100"; break;
		case "over100": achievementRateStart = "100";
						achievementRateEnd = ""; break;
		default: achievementRateStart = "";
				achievementRateEnd = "";
		}
		
		String[] scales = {achievementRateStart, achievementRateEnd};
		
		return scales;
	}
	
}
