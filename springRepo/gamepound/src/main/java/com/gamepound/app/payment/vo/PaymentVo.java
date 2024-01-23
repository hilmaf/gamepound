package com.gamepound.app.payment.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PaymentVo {

	private String no;
	private String backNo;
	private String backName;			// 후원자 이름
	private String projectNo;
	private String projectTitle;		// 프로젝트 타이틀
	private String projectStatusNo;
	private String projectStatus;		// 프로젝트 스테이터스 이름
	private String paymentTypeNo;
	private String paymentType; 		// 타입이름
	private String paymentStatusNo;
	private String paymentStatus;		// 페이먼트 스테이터스 이름
	private String paymentDate;
	private String paymentDueDate;
	private String amount;
	
}
