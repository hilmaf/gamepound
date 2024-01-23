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
	
	//목록
	public List<MemberVo> memberList(MemberVo vo) {
		return dao.memberList(vo,sst);
	}

	//상세
	public MemberVo memberDetail(MemberVo vo) {
		return dao.memberDetail(sst, vo);
	}

	//수정
	public int memberEdit(MemberVo vo) {
		return dao.memberEdit(sst, vo);
	}

	//삭제
	public int memberDelete(MemberVo vo) {
		return dao.memberDelete(sst, vo);
	}
}
