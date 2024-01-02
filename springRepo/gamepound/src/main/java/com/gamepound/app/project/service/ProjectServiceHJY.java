package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.dao.ProjectDaoHJY;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHJY {
	
	private final ProjectDaoHJY dao;
	private final SqlSessionTemplate sst;

	// 작성중 프로젝트 조회
	public List<ProjectVo> getCurrentProject(MemberVo loginMember) {
		return dao.getCurrentProject(sst, loginMember);
	}
	
}
