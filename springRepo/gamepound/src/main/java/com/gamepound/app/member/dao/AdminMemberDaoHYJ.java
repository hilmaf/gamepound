package com.gamepound.app.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class AdminMemberDaoHYJ {

	public List<MemberVo> memberList(MemberVo vo, SqlSessionTemplate sst) {
		return sst.selectList("AdminMemberMapper.List", vo);
	}

}
