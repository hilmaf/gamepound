package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class ProjectDaoLKM {

	public List<ProjectVo> searchProject(SqlSessionTemplate sst, String query) {
		return sst.selectList("SearchMapper.searchProject", query);
	}

}
