package com.gamepound.app.payment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.payment.dao.PaymentDaoLKM;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceLKM {

	private final SqlSessionTemplate sst;
	private final PaymentDaoLKM dao;
}
