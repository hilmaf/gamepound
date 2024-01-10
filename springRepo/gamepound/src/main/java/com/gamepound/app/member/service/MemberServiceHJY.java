package com.gamepound.app.member.service;


import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.controller.TokenUtil;
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
		
		// 이메일 검증
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

	// 비밀번호 찾기 : 이메일 확인 01.10 메일바로보내기로 삭제
//	public int confirmPassword(MemberVo vo) {
//		return dao.confirmPassword(sst, vo);
//	}

	// 비밀번호 재설정 처리
	public Map<String, String> resetPassword(MemberVo vo) throws Exception {
		
		Map<String, String> map = new HashMap<>();
		
		// 비밀번호 일치여부 검증
		if(vo.getPwd() == null || vo.getConfirmPwd() == null || !vo.getPwd().equals(vo.getConfirmPwd())) {
			map.put("badMsg", "비밀번호가 일치하지 않습니다.");
			map.put("msg", "bad");
			return map;
		}
		
		// 토큰 검증
		boolean isValid = TokenUtil.validateToken(vo.getEmail());
		if(isValid) {
			// 토큰 이메일값 풀기
	        String emailFromToken = TokenUtil.getFromToken(vo.getEmail());
	        vo.setEmail(emailFromToken);
		} else {
			map.put("msg", "bad");
			map.put("badMsg", "토큰이 만료되었습니다.");
			return map;
		}
		
		// 결과 리턴
		int result = dao.resetPassword(sst, vo);
		map.put("msg", "good");
		if(result != 1) {
			map.put("badMsg", "사용할 수 없는 이메일입니다.");
			map.put("msg", "bad");
		}
		
		return map;
	}

	// 회원 탈퇴처리
	public int quit(MemberVo vo) {
		return dao.quit(sst, vo);
	}

}
