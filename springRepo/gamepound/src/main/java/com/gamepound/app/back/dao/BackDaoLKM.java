package com.gamepound.app.back.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;

@Repository

public class BackDaoLKM {

	// 후원하기(화면)
	public BackVo viewBackingPage(SqlSessionTemplate sst, BackVo vo) {
		return sst.selectOne("BackMapper.viewBackingInfo", vo);
	}
	
	// 후원 insert 작업
	public int insertBack(SqlSessionTemplate sst, BackDetailVo vo) {
		return sst.insert("BackMapper.insertBack", vo);
	}
	
	// 결제정보 insert 작업
	public int insertPayment(SqlSessionTemplate sst, BackDetailVo vo) {
		return sst.insert("BackMapper.insertPayment", vo);
	}
	
	// 카드 정보 insert 작업
	public int insertCard(SqlSessionTemplate sst, BackDetailVo vo) {
		return sst.insert("BackMapper.insertCard", vo);
	}
	
	// 카카오페이 정보 insert 작업
	public int insertKakaopay(SqlSessionTemplate sst, BackDetailVo vo) {
		return sst.insert("BackMapper.insertKakaopay", vo);
	}
	
	// 후원완료(nth 후원)
	public String cntBacker(SqlSessionTemplate sst, String projectNo) {
		return sst.selectOne("BackMapper.cntBacker", projectNo);
	}

	// 후원 취소(후원정보 update)
	public int updateRetractYn(SqlSessionTemplate sst, String backNo) {
		return sst.update("BackMapper.updateRetractYn", backNo);
	}
	
	// 후원 취소(결제정보 delete)
	public int updatePayment(SqlSessionTemplate sst, String backNo) {
		return sst.update("BackMapper.updatePayment", backNo);
	}

	// 후원 상세 조회
	public BackDetailVo detail(SqlSessionTemplate sst, String backNo) {
		return sst.selectOne("BackMapper.detail", backNo);
	}

	// 후원 내용 변경 - 선물 변경
	public int changeReward(SqlSessionTemplate sst, BackVo vo) {
		return sst.update("BackMapper.changeReward", vo);
	}

	// 후원 내용 변경 - 결제 수단 변경
	public int changePayment(SqlSessionTemplate sst, BackVo vo) {
		return sst.update("BackMapper.changePayment", vo);
	}
	
	

	

	

}
