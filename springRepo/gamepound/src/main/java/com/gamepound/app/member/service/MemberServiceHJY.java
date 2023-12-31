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
	public MemberVo login(MemberVo vo) throws Exception {
		return dao.login(sst, vo);
	}

	// 회원가입 처리
	public int join(MemberVo vo) throws Exception {
		// TODO: 이메일 인증 필요
		
		// 아이디 검증
		if(!MemberValidation.isValidEmail(vo.getEmail())) {
			throw new Exception("이메일이 유효하지 않습니다.");
		}
		
		// 이름 검증
		if(!MemberValidation.isValidName(vo.getName())) {
			throw new Exception("이름이 유효하지 않습니다.");
		}
		
		// 비밀번호 검증
		if(!MemberValidation.isValidPwd(vo.getPwd())) {
			throw new Exception("비밀번호가 유효하지 않습니다.");
		}
		
		return dao.join(sst, vo);
	}

}
