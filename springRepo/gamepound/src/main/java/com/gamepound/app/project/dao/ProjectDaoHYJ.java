package com.gamepound.app.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectStoryVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class ProjectDaoHYJ {

	//목록 조회 - 카테고리
	public List<ProjectVo> projectListCategory(SqlSessionTemplate sst, ProjectListVo vo) {
		return sst.selectList("ProjectMapper.ListCategory", vo);
	}

	//목록 조회 - 인기순
	public List<ProjectVo> projectListPopular(SqlSessionTemplate sst, ProjectListVo vo) {
		//TODO-HYJ : [list-popular] 달성률 순으로 작성
		return sst.selectList("ProjectMapper.ListPopular", vo);
	}

	//목록 조회 - 신규
	public List<ProjectVo> projectListNew(SqlSessionTemplate sst, ProjectListVo vo) {
		//TODO-HYJ : [list-new] 현재 날짜 이후 날짜 제외 시키는구문 추가해야함 (현재 1월1일이면 1월 2일 예정인거 제외시켜야함)
		return sst.selectList("ProjectMapper.ListNew", vo);
	}

	//목록 조회 - 마감임박
	public List<ProjectVo> projectListImminent(SqlSessionTemplate sst, ProjectListVo vo) {
		//TODO-HYJ : [list-imminent] 현재 날짜보다 이전인거 제외 시키는 구문 추가해야함 (현재 1월 2일이면 1월 1일에 마감된거 제외시켜야함)
		return sst.selectList("ProjectMapper.ListImminent", vo);
	}

	//목록 조회 - 공개예정
	public List<ProjectVo> projectListPrelaunch(SqlSessionTemplate sst) {
		// TODO-HYJ : [list-prelaunch] vo에서 가져올때 오픈일이 현재 시간보다 늦어야함
		return sst.selectList("ProjectMapper.ListPrelaunch");
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//상세조회 - 타이틀 + 선물
	public ProjectDetailVo projectDetail(SqlSessionTemplate sst, String no) {
		ProjectDetailVo detailVo = sst.selectOne("ProjectMapper.DetailTitle", no);
		detailVo.setRewardVo(sst.selectList("ProjectMapper.DetailReward", no));
		return detailVo;
	}

	//상세조회 - 계획
	public ProjectStoryVo projectDetailStory(SqlSessionTemplate sst, String no) {
		return sst.selectOne("ProjectMapper.DetailStory", no);
	}

	//프로젝트 상세 조회 - 업데이트
	public List<ProjectUpdateVo> projectDetailUpdate(SqlSessionTemplate sst, String no) {
		return sst.selectList("ProjectMapper.DetailUpdate", no);
	}

	//프로젝트 상세 조회 - 커뮤니티
	public List<ProjectCommunityVo> projectDetailCommunity(SqlSessionTemplate sst, String no) {
		return sst.selectList("ProjectMapper.DetailCommunity", no);
	}

	//프로젝트 상세 조회 - 업데이트 작성
	public int projectDetailUpdate(SqlSessionTemplate sst, ProjectUpdateVo vo) {
		return sst.insert("ProjectMapper.DetailUpdateInsert", vo);
	}

	//프로젝트 상세 조회 - 커뮤니티 작성(댓글)
	public int projectDetailCommunityReply(SqlSessionTemplate sst, ProjectCommunityVo vo) {
		return sst.update("ProjectMapper.DetailCommunityReplyInsert", vo);
	}

	//프로젝트 상세 조회 - 커뮤니티 작성
	public int projectDetailCommunity(SqlSessionTemplate sst, ProjectCommunityVo vo) {
		return sst.insert("ProjectMapper.DetailCommunityInsert", vo);
	}



}
