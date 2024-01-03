package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class ProjectDaoHJY {

	// 작성중 프로젝트 조회
	public List<ProjectVo> getCurrentProject(SqlSessionTemplate sst, MemberVo loginMember) {
		return sst.selectList("ProjectCreateMapper.getCurrentProject", loginMember);
	}

	// 프로젝트 올리기 (카테고리 저장 및 insert)
	public int newProject(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.insert("ProjectCreateMapper.newProject", vo);
	}

	// 프로젝트 내용 조회 (메인)
	public ProjectVo createMain(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("ProjectCreateMapper.createMain", vo);
	}

}
