package com.gamepound.app.member.service;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		// TODO: 이메일 검증확인으로 변경 필요
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

	// 아이디 중복검사
	public int isEmailUnique(MemberVo vo) throws Exception {
		
		// 이메일 형식 검증
		if(!MemberValidation.isValidEmail(vo.getEmail())) {
			throw new Exception("이메일형식이 맞지 않습니다.");
		}
		
		return dao.isEmailUnique(sst, vo);
	}

	// 비밀번호 찾기 : 이메일, 비밀번호 재확인
	public int confirmPassword(MemberVo vo) {
		return dao.confirmPassword(sst, vo);
	}

	// 비밀번호 재설정 처리
	public int resetPassword(MemberVo vo) throws Exception {
		if(vo.getPwd() == null || vo.getConfirmPwd() == null || !vo.getPwd().equals(vo.getConfirmPwd())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}
		return dao.resetPassword(sst, vo);
	}

	// 회원 탈퇴처리
	public int quit(MemberVo vo) {
		return dao.quit(sst, vo);
	}

}
