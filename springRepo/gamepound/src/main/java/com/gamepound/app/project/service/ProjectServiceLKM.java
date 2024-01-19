package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoLKM;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.project.vo.ProjectListVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceLKM {

	private final SqlSessionTemplate sst;
	private final ProjectDaoLKM dao;
	
	// 프로젝트 검색
	public List<ProjectBriefVo> searchProject(ProjectListVo vo) {
		
		System.out.println(vo);
		
		
		
		
		
		List<ProjectBriefVo> searchedList = dao.searchProject(sst, vo);
		
		String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
		
		for (ProjectBriefVo projectVo : searchedList) {
			projectVo.setProjectImg(url + projectVo.getProjectImg());
		}
		
		return searchedList;
	}
	
	
}
