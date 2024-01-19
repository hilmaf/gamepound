package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.project.vo.ProjectListVo;

@Repository
public class ProjectDaoLKM {

	public List<ProjectBriefVo> searchProject(SqlSessionTemplate sst, ProjectListVo vo2) {
		return sst.selectList("SearchMapper.searchProject", vo2);
	}

}
