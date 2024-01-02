package com.gamepound.app.back.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.BackVo;

@Repository

public class BackDaoLKM {

	public int back(SqlSessionTemplate sst, BackVo vo) {
		return sst.insert("BackMapper.back", vo);
	}

	public String cntBacker(SqlSessionTemplate sst, String projectNo) {
		return sst.selectOne("BackMapper.cntBacker", projectNo);
	}

}
