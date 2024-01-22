package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectSearchVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class AdminProjectDaoLKM {

	public List<ProjectVo> list(SqlSessionTemplate sst) {
		int offset = 0;
		int limit = 0;
		return sst.selectList("AdminProjectMapper.list");
	}

	public List<ProjectDetailVo> detail(SqlSessionTemplate sst, String projectNo) {
		return sst.selectList("AdminProjectMapper.detail", projectNo);
	}

	public int approve(SqlSessionTemplate sst, String projectNo) {
		return sst.update("AdminProjectMapper.approve", projectNo);
	}

	public int reject(SqlSessionTemplate sst, String projectNo) {
		return sst.update("AdminProjectMapper.reject", projectNo);
	}

	public List<ProjectVo> search(SqlSessionTemplate sst, ProjectSearchVo vo) {
		return sst.selectList("AdminProjectMapper.search", vo);
	}

}
