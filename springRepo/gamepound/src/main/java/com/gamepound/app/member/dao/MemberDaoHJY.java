package com.gamepound.app.member.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class MemberDaoHJY {

	// 로그인 처리
	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberMapper.login", vo);
	}

	// 회원가입 처리
	public int join(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("MemberMapper.join", vo);
	}

	// 이메일 중복검사
	public int isEmailUnique(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberMapper.isEmailUnique", vo);
	}

	// 비밀번호 찾기 : 이메일, 비밀번호 재확인 01.10 메일바로보내기로 삭제
//	public int confirmPassword(SqlSessionTemplate sst, MemberVo vo) {
//		return sst.selectOne("MemberMapper.confirmPassword", vo);
//	}

	// 비밀번호 재설정 처리
	public int resetPassword(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberMapper.resetPassword", vo);
	}

	// 회원 탈퇴처리
	public int quit(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberMapper.quit", vo);
	}

	// 회원번호로 회원 조회
	public MemberVo selectByNo(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberMapper.selectByNo", vo);
	}

}
