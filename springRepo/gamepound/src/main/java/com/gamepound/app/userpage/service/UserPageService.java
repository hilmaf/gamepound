package com.gamepound.app.userpage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.review.vo.ReviewStatVo;
import com.gamepound.app.review.vo.ReviewVo;
import com.gamepound.app.userpage.dao.UserPageDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserPageService {

	private final SqlSessionTemplate sst;
	private final UserPageDao dao;
	
	// 유저페이지 - 리뷰목록, 리뷰 통계 조회
	public Map<String, Object> listReview(String memberNo) {
		// 리뷰 목록
		List<ReviewVo> reviewList = dao.listReview(sst, memberNo);
		// 리뷰 통계
		ReviewStatVo statVo = dao.getStat(sst, memberNo);
		
		// map에 넣기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewList", reviewList);
		map.put("statVo", statVo);
		
		return map;
	}
	
}
