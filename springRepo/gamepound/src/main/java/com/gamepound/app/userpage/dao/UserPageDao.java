package com.gamepound.app.userpage.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.BackVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;

@Repository

public class UserPageDao {

	// 리뷰 목록
	public List<ReviewVo> listReview(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("ReviewMapper.listReview", memberNo);
	}

	// 리뷰 통계 정보
	public ReviewStatVo getStat(SqlSessionTemplate sst, String memberNo) {
		return sst.selectOne("ReviewMapper.getReviewStat", memberNo);
	}
	
	// 리뷰 작성
	public int write(SqlSessionTemplate sst, ReviewVo vo) {
		return sst.insert("UserPageMapper.writeReview", vo);
	}

	// 내가 올린 프로젝트 목록 조회
	public List<ProjectVo> listMyProjects(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("UserPageMapper.listMyProjects", memberNo);
	}

	// 내 후원 목록 - 후원 성공
	public List<BackVo> backedSuccessfully(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("UserPageMapper.backedSuccessfully", memberNo);
	}

	// 내 후원 목록 - 후원 실패
	public List<BackVo> backedUnsuccessfully(SqlSessionTemplate sst, String memberNo) {
		return sst.selectList("UserPageMapper.backedUnsuccessfully", memberNo);
	}
	

	
}
