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
	private String paymentDate;
	private String paymentDueDate;
	private String amount;
	
}
