package com.gamepound.app.payment.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.payment.dao.PaymentDaoLKM;
import com.gamepound.app.payment.vo.PaymentVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceLKM {

	private final SqlSessionTemplate sst;
	private final PaymentDaoLKM dao;
	
	// 결제하기
	public void pay(PaymentVo vo) {
		// business logic
		// 펀딩이 종료 & 성공한 프로젝트의 후원 목록 가져오기
		List<PaymentVo> paymentList = dao.getPaymentList(sst); //TODO: 매개변수로 당일 날짜 받아오기
		
		// 프로젝트/후원 목록에 잘못 들어간 건 없는지 다시 한 번 체크
		// 펀딩이 종료되지 않은 프로젝트의 후원 결제 요청이 들어오면 예외 던지기
		
		// 펀딩 실패한 프로젝트의 후원 결제 요청이 들어오면 예외 던지기
		
		// 결제 요청
		
		// 결제상태 update
//		if(결제가 성공했을 때) {
//			int result = dao.updatePaymentStatusToPaid(sst);			
//		} else {
//			int result = dao.updatePaymentStatusToDeclined(sst);
//		}
		// 결제상태 update 잘 됐는지 확인절차 : paymentList.length() == 결제상태 update result
	}
}
