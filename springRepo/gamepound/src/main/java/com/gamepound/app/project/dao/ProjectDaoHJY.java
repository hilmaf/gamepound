package com.gamepound.app.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.vo.ProjectVo;

@Repository
public class ProjectDaoHJY {

	// 작성중 프로젝트 조회
	public List<ProjectVo> getCurrentProject(SqlSessionTemplate sst, MemberVo loginMember) {
		return sst.selectList("ProjectCreateMapper.getCurrentProject", loginMember);
	}

}
