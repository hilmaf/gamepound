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
	
	// �α��� ó��
	public MemberVo login(MemberVo vo) {
		
		// TODO: �������� ó��, ��������ť��Ƽ ����, ��ȣȭ ���� 1230������
		return dao.login(sst, vo);
		
	}

}
