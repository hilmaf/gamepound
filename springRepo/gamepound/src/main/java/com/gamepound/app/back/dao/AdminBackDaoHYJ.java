package com.gamepound.app.back.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.back.vo.AdminBackVo;

@Repository
public class AdminBackDaoHYJ {

	//목록
	public List<AdminBackVo> backList(SqlSessionTemplate sst) {
		return sst.selectList("AdminBackMapper.List");
	}

	//목록 조회시 게시글 갯수
	public int listCnt(SqlSessionTemplate sst, AdminBackVo vo) {
		return sst.selectOne("AdminBackMapper.Cnt", vo);
	}
	
	public AdminBackVo backDetail(SqlSessionTemplate sst, AdminBackVo vo) {
		return sst.selectOne("AdminBackMapper.Detail", vo);
	}


}
