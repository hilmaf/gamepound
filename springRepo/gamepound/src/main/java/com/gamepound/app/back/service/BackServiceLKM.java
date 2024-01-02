package com.gamepound.app.back.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.BackDaoLKM;
import com.gamepound.app.back.vo.BackVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BackServiceLKM {

	private final BackDaoLKM dao;
	private final SqlSessionTemplate sst;
	
	public int back(BackVo vo) {
		// TODO: 후원 business logic
		
		return dao.back(sst, vo);
	}

	public String cntBacker(String projectNo) {		
		return dao.cntBacker(sst, projectNo);
	}

}
