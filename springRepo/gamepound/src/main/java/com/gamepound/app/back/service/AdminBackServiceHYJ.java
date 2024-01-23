package com.gamepound.app.back.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.AdminBackDaoHYJ;
import com.gamepound.app.back.vo.AdminBackVo;
import com.gamepound.app.member.dao.MemberDaoHYJ;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminBackServiceHYJ {
	private final AdminBackDaoHYJ dao;
	private final SqlSessionTemplate sst;
	
	//목록
	public List<AdminBackVo> backList() {
		return dao.backList(sst);
	}

	//상세
	public AdminBackVo backDetail(AdminBackVo vo) {
		return dao.backDetail(sst, vo);
	}
}
