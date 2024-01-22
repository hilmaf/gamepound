package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class AdminProjectDaoLKM {

	public List<ProjectVo> list(SqlSessionTemplate sst) {
		return sst.selectList("AdminProjectMapper.list");
	}

	public List<ProjectDetailVo> detail(SqlSessionTemplate sst, String projectNo) {
		return sst.selectList("AdminProjectMapper.detail");
	}

}
