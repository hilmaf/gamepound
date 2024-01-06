package com.gamepound.app.payment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.payment.vo.PaymentVo;

@Repository
public class PaymentDaoLKM {

	// 결제할 리스트 가져오기
	public List<PaymentVo> getPaymentList(SqlSessionTemplate sst) {
		return sst.selectList("PaymentMapper.getPaymentList");
	}

	
	// 결제 상태 업데이트 - 결제성공
	public int updatePaymentStatusToPaid(SqlSessionTemplate sst) {
		return sst.update("PaymentMapper.updatePaymentStatusToPaid");
	}

	// 결제 상태 업데이트 - 결제실패
	public int updatePaymentStatusToDeclined(SqlSessionTemplate sst) {
		return sst.update("PaymentMapper.updatePaymentStatusToDeclined");
	}

	
}
