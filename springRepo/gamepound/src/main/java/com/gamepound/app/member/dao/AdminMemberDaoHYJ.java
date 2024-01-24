package com.gamepound.app.member.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.page.vo.PageVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class AdminMemberDaoHYJ {

	//목록
	public List<MemberVo> memberList(SqlSessionTemplate sst, MemberVo vo, PageVo pvo) {
		// 몇개의 게시물 건너뛸건지
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); 
		
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		
		return sst.selectList("AdminMemberMapper.List", vo, rb);
	}
	
	//목록 조회 시 게시글 갯수
	public int listCnt(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("AdminMemberMapper.Cnt", vo);
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
