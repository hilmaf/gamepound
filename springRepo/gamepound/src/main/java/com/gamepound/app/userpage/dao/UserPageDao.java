package com.gamepound.app.userpage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.page.vo.PageVo;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;

@Repository
public class UserPageDao {

	// 프로필 소개
	public String userIntro(SqlSessionTemplate sst, String memberNo) {
		return sst.selectOne("UserPageMapper.userIntro", memberNo);
	}
	
	// 특정 유저에게 달린 리뷰 CNT
	public String userReviewCnt(SqlSessionTemplate sst, String memberNo) {
		return sst.selectOne("UserPageMapper.userReviewCnt", memberNo);
	}
	
	// 리뷰 목록
	public List<ReviewVo> listReview(SqlSessionTemplate sst, String memberNo, PageVo pvo) {
		int offset = (pvo.getCurrentPage()-1) * pvo.getBoardLimit();
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		
		return sst.selectList("UserPageMapper.listReview", memberNo, rb);
	}

	// 리뷰 통계 정보
	public ReviewStatVo getStat(SqlSessionTemplate sst, String memberNo) {
		return sst.selectOne("UserPageMapper.getReviewStat", memberNo);
	}
	
	// 리뷰 작성
	public int write(SqlSessionTemplate sst, ReviewVo vo) {
		return sst.insert("UserPageMapper.writeReview", vo);
	}

	// 내가 올린 프로젝트 목록 조회
	public List<ProjectBriefVo> listMyProjects(SqlSessionTemplate sst, Map<String, Object> map) {
		return sst.selectList("UserPageMapper.listMyProjects", map);
	}
	
	// 내가 올린 프로젝트 목록 cnt
	public String myProjectsCnt(SqlSessionTemplate sst, Map<String, Object> map) {
		return sst.selectOne("UserPageMapper.myProjectCnt", map);
	}

	// 내 후원 목록 - 후원 성공
	public List<BackDetailVo> backedSuccessfully(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("UserPageMapper.backedSuccessfully", memberNo);
	}

	// 내 후원 목록 - 후원 실패
	public List<BackDetailVo> backedUnsuccessfully(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("UserPageMapper.backedUnsuccessfully", memberNo);
	}
	
	// 해당 후원에 대한 내 후기 보기
	public ReviewVo viewMyReview(SqlSessionTemplate sst, String reviewNo) {
		return sst.selectOne("UserPageMapper.myReview", reviewNo);
	}

	// 유저페이지 - 프로필
	public MemberVo userProfile(SqlSessionTemplate sst, String memberNo) {
		return sst.selectOne("UserPageMapper.userProfile", memberNo);
	}
	
}
