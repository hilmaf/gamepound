package com.gamepound.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.dao.AdminMemberDaoHYJ;
import com.gamepound.app.member.dao.MemberDaoHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminMemberServiceHYJ {
	private final AdminMemberDaoHYJ dao;
	private final SqlSessionTemplate sst;
	
	//사용자관리 목록
	public List<MemberVo> memberList(MemberVo vo) {
		return dao.memberList(vo,sst);
	}
}
