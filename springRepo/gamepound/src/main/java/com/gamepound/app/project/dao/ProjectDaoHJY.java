package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;

@Repository
public class ProjectDaoHJY {
	
	/**
	 * 현지연 프로젝트 dao
	 * */

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

	// 프로젝트 작성조회 : 기본정보
	public ProjectVo getBasic(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("ProjectCreateMapper.getBasic", vo);
	}

	// 프로젝트 작성조회 : 펀딩계획
	public ProjectVo getPlan(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("ProjectCreateMapper.getPlan", vo);
	}

	// 프로젝트 작성조회 : 프로젝트 계획
	public ProjectVo getDateplan(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("ProjectCreateMapper.getDateplan", vo);
	}

	
	
	// 프로젝트 작성저장 : 기본정보
	public int saveBasic(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.update("ProjectCreateMapper.saveBasic", vo);
	}

	// 프로젝트 작성저장 : 펀딩계획
	public int savePlan(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.update("ProjectCreateMapper.savePlan", vo);
	}

	// 프로젝트 작성 : 선물구성
	public int createReword(SqlSessionTemplate sst, RewardVo vo) {
		return sst.insert("ProjectCreateMapper.createReword", vo);
	}

}
