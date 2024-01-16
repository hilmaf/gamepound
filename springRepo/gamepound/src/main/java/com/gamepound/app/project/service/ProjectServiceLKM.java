package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoLKM;
import com.gamepound.app.project.vo.ProjectBriefVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceLKM {

	private final SqlSessionTemplate sst;
	private final ProjectDaoLKM dao;
	
	// 프로젝트 검색
	public List<ProjectBriefVo> searchProject(String query) {
		
		List<ProjectBriefVo> searchedList = dao.searchProject(sst, query);
		
		String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
		
		for (ProjectBriefVo vo : searchedList) {
			vo.setProjectImg(url + vo.getProjectImg());
		}
		
		return searchedList;
	}
	
	
}
