package com.gamepound.app.project.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.ProjectDaoHYJ;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHYJ {
	private final ProjectDaoHYJ dao;
	private final SqlSessionTemplate sst;
}
