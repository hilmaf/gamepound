package com.gamepound.app.payment.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PaymentVo {

	private String backNo;
	private String projectNo;
	private String projectStatusNo;
	private String paymentTypeNo;
	private String paymentStatusNo;
	private String paidDate;
	private String amount;
	
}
