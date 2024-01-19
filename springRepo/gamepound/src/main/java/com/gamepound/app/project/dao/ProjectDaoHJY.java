package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;
import com.gamepound.app.settlement.vo.SettlementVo;

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
	public ProjectVo newProject(SqlSessionTemplate sst, ProjectVo vo) throws Exception {
		int result = sst.insert("ProjectCreateMapper.newProject", vo);
		ProjectVo projectVo = new ProjectVo();
		if(result == 1) {
			String projectNo = vo.getNo();
			projectVo.setNo(projectNo);
		} else {
			throw new Exception("insert가 진행되지 않았습니다.");
		}
		return projectVo;
	}

	// 프로젝트 내용 조회 (메인)
	public ProjectVo createMain(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("ProjectCreateMapper.createMain", vo);
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

	// 프로젝트 작성저장 : 선물구성
	public int saveReword(SqlSessionTemplate sst, RewardVo vo) {
		return sst.update("ProjectCreateMapper.saveReword", vo);
	}

	// 프로젝트 선물삭제 : 선물구성
	public int deleteReword(SqlSessionTemplate sst, RewardVo vo) {
		return sst.delete("ProjectCreateMapper.deleteReword", vo);
	}

	// 프로젝트 작성저장 : 프로젝트 계획
	public int saveDateplan(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.update("ProjectCreateMapper.saveDateplan", vo);
	}

	// 프로젝트 작성저장 : 창작자 정보
	public int saveUserinfo(SqlSessionTemplate sst, SettlementVo vo) {
		return sst.update("ProjectCreateMapper.saveUserinfo", vo);
	}

	// 프로젝트 승인 요청
	public int approvalProject(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.update("ProjectCreateMapper.approvalProject", vo);
	}

}
