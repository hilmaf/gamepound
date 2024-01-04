package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoLKM;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceLKM {

	private final SqlSessionTemplate sst;
	private final ProjectDaoLKM dao;
	
	// 프로젝트 검색
	public List<ProjectVo> searchProject(String keyword) {
		return dao.searchProject(sst, keyword);
	}
	
	
}
