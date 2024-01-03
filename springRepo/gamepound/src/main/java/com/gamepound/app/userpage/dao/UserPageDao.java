package com.gamepound.app.userpage.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
		return sst.selectOne("ReviewMapper.getStat", memberNo);
	}
	

	
}
