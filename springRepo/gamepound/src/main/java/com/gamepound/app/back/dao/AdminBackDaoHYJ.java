package com.gamepound.app.back.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.AdminBackVo;
import com.gamepound.app.page.vo.PageVo;

@Repository
public class AdminBackDaoHYJ {

	//목록
	public List<AdminBackVo> backList(SqlSessionTemplate sst, AdminBackVo vo, PageVo pvo) {
		//몇개의 게시물 건너뛸건지
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); 
		
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("AdminBackMapper.List", vo, rb);
	}

	//목록 조회시 게시글 갯수
	public int listCnt(SqlSessionTemplate sst, AdminBackVo vo) {
		return sst.selectOne("AdminBackMapper.Cnt", vo);
	}

}
