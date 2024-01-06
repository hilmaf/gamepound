package com.gamepound.app.payment.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.payment.PaymentRequest;
import com.gamepound.app.payment.dao.PaymentDaoLKM;
import com.gamepound.app.payment.vo.PaymentVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceLKM {

	private final SqlSessionTemplate sst;
	private final PaymentDaoLKM dao;
	
	// 결제하기
	public void pay(PaymentVo vo) throws Exception {
		// business logic
		// 펀딩이 종료 & 성공한 프로젝트의 후원 목록 가져오기
		List<PaymentVo> paymentList = dao.getPaymentList(sst); //TODO: 매개변수로 당일 날짜 받아오기
		
		// 프로젝트/후원 목록에 잘못 들어간 건 없는지 다시 한 번 체크
		// 프로젝트 상태 번호가 6이 아닌 후원내  역이면 예외 던지기
		for(PaymentVo payVo : paymentList) {
			if(payVo.getProjectStatusNo() != "6") {
				throw new Exception("결제하면 안되는 후원 내역");
			}
		}
		
		// 결제 요청
		PaymentRequest pr = new PaymentRequest();
		pr.requestPayment();
		
		// 결제상태 update
//		if(결제가 성공했을 때) {
//			int result = dao.updatePaymentStatusToPaid(sst);			
//		} else {
//			int result = dao.updatePaymentStatusToDeclined(sst);
//		}
		
		// 결제상태 update 잘 됐는지 확인절차 : paymentList.length() == 결제상태 update result
	}

}
