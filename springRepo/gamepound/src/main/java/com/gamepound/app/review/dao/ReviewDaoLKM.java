package com.gamepound.app.review.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.review.vo.ReviewVo;

@Repository

public class ReviewDaoLKM {

	public int write(SqlSessionTemplate sst, ReviewVo vo) {
		return sst.insert("ReviewMapper.write", vo);
	}

}
