package com.gamepound.app.back.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.BackVo;

@Repository

public class BackDaoLKM {

	// 후원 insert 작업
	public int back(SqlSessionTemplate sst, BackVo vo) {
		return sst.insert("BackMapper.back", vo);
	}

	// 후원완료(nth 후원)
	public String cntBacker(SqlSessionTemplate sst, String projectNo) {
		return sst.selectOne("BackMapper.cntBacker", projectNo);
	}

	// 후원 취소
	public int cancel(SqlSessionTemplate sst, String backNo) {
		return sst.update("BackMapper.cancel", backNo);
	}

	// 후원 상세 조회
	public BackVo detail(SqlSessionTemplate sst, String backNo) {
		return sst.selectOne("BackMapper.detail", backNo);
	}

}
