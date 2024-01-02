package com.gamepound.app.review.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.review.dao.ReviewDaoLKM;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceLKM {

	private final SqlSessionTemplate sst;
	private final ReviewDaoLKM dao;
}
