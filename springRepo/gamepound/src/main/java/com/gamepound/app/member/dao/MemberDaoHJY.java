package com.gamepound.app.member.dao;

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

	public int isEmailUnique(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberMapper.isEmailUnique", vo);
	}

}
