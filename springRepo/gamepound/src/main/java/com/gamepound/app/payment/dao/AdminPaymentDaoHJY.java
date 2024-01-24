package com.gamepound.app.payment.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.page.vo.PageVo;
import com.gamepound.app.payment.vo.PaymentStatusVo;
import com.gamepound.app.payment.vo.PaymentVo;

@Repository
public class AdminPaymentDaoHJY {

	// 전체 조회 갯수
	public int countPaymentList(SqlSessionTemplate sst) {
		return sst.selectOne("AdminPaymentMapper.countPaymentList");
	}

	// 전체 조회
	public List<PaymentVo> getPaymentList(SqlSessionTemplate sst, PageVo pvo) {
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); // 몇개의 게시물 건너뛸건지
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("AdminPaymentMapper.getPaymentList", null, rb);
	}

	// 결제 상태 리스트 가져오기
	public List<PaymentStatusVo> getPaymentStatus(SqlSessionTemplate sst) {
		return sst.selectList("AdminPaymentMapper.getPaymentStatus");
	}

	// 검색 리스트 카운트
	public int countPaymentSearchList(SqlSessionTemplate sst, Map<String, String> vo) {
		return sst.selectOne("AdminPaymentMapper.countPaymentSearchList", vo);
	}

	// 검색 조회하기
	public List<PaymentVo> getPaymentSearchList(SqlSessionTemplate sst, Map<String, String> vo, PageVo pvo) {
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); // 몇개의 게시물 건너뛸건지
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("AdminPaymentMapper.getPaymentSearchList", vo, rb);
	}

}
