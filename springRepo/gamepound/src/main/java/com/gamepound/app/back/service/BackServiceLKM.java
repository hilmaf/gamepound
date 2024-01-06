package com.gamepound.app.back.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.BackDaoLKM;
import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BackServiceLKM {

	private final BackDaoLKM dao;
	private final SqlSessionTemplate sst;
	
	// 후원하기
	public boolean back(BackDetailVo vo) throws Exception {
		// NullCheck
		if(vo.getPaymentType() == null) {
			throw new Exception("결제수단 선택 필요");
		}
		
		// 후원정보에 insert
		int result1 = dao.insertBack(sst, vo);
		
		// 결제정보에 insert
		int result2 = dao.insertPayment(sst, vo);
		
		if(result1 != 1 && result2 != 1) {
			throw new Exception("후원 등록에 실패함");
		}

		boolean backed = true;
		
		return backed;
	}

	// 후원완료(n번째 후원자)
	public String cntBacker(String projectNo) {		
		return dao.cntBacker(sst, projectNo);
	}

	// 후원취소
	public boolean cancel(String backNo) throws Exception {
		
		// 후원정보 update
		int result1 = dao.updateRetractYn(sst, backNo);
		// 결제정보 delete
		int result2 = dao.deletePayment(sst, backNo);
		
		if(result1 != 1 && result2 != 1) {
			throw new Exception("후원 취소에 실패함");
		}
		
		boolean canceled = true;
		
		return canceled;
	}
	
	// 후원 상세 조회
	public BackVo detail(String backNo) {
		return dao.detail(sst, backNo);
	}

	// 후원 내용 변경 - 선물 변경
	public int changeReward(BackVo vo) {
		return dao.changeReward(sst, vo);
	}

	public int changePaymentType(BackVo vo) {
		return dao.changePayment(sst, vo);
	}

}
