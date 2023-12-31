package com.gamepound.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.dao.MemberDaoHJY;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceHJY {
	
	private final MemberDaoHJY dao;
	private final SqlSessionTemplate sst;
	
	// 로그인 처리
	public MemberVo login(MemberVo vo) {
		
		// TODO: 검증로직 처리, 스프링시큐리티 적용, 암호화 적용 1230현지연
		return dao.login(sst, vo);
		
	}

}
