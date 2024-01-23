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

	public AdminBackVo backDetail(SqlSessionTemplate sst, AdminBackVo vo) {
		return sst.selectOne("AdminBackMapper.Detail", vo);
	}

}
