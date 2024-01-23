package com.gamepound.app.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class AdminMemberDaoHYJ {

	//사용자관리 목록
	public List<MemberVo> memberList(MemberVo vo, SqlSessionTemplate sst) {
		return sst.selectList("AdminMemberMapper.List", vo);
	}

	//사용자관리 상세
	public MemberVo memberDetail(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("AdminMemberMapper.detail", vo);
	}

}
