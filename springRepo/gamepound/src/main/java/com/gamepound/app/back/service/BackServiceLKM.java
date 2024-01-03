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
	
	// 후원하기
	public int back(BackVo vo) throws Exception {
		// NullCheck
		if(vo.getPaymentType() == null) {
			throw new Exception("결제수단 선택 필요");
		}
		
		return dao.back(sst, vo);
	}

	// 후원완료(n번째 후원자)
	public String cntBacker(String projectNo) {		
		return dao.cntBacker(sst, projectNo);
	}

	// 후원취소
	public int cancel(String backNo) {
		return dao.cancel(sst, backNo);
	}

}
