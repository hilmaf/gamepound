package com.gamepound.app.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class AdminMemberDaoHYJ {

	//목록
	public List<MemberVo> memberList(MemberVo vo, SqlSessionTemplate sst) {
		return sst.selectList("AdminMemberMapper.List", vo);
	}

	//상세
	public MemberVo memberDetail(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("AdminMemberMapper.detail", vo);
	}

	//수정
	public int memberEdit(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("AdminMemberMapper.edit", vo);
	}

	//삭제
	public int memberDelete(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("AdminMemberMapper.delete", vo);
	}

}
