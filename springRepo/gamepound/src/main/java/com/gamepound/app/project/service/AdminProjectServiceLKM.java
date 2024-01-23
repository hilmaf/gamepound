package com.gamepound.app.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.project.dao.AdminProjectDaoLKM;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectSearchVo;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVoLKM;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminProjectServiceLKM {

	private final SqlSessionTemplate sst;
	private final AdminProjectDaoLKM dao;
	
	public List<ProjectVo> list(ProjectSearchVo vo) {
		return dao.list(sst, vo);
	}

	public ProjectDetailVo detail(String projectNo) {
		List<ProjectDetailVo> list = dao.detail(sst, projectNo);
		
		Map<String, ProjectDetailVo> map = new HashMap<String, ProjectDetailVo>();
		for(ProjectDetailVo vo : list) {
			map.put(vo.getNo(), vo);
		}
		
		for(ProjectDetailVo vo : list) {
			RewardVoLKM rewardVo = new RewardVoLKM();
			rewardVo.setRewardNo(vo.getRewardNo());
			rewardVo.setRewardName(vo.getRewardName());
			rewardVo.setRewardAmount(vo.getRewardAmount());
			rewardVo.setProjectNo(vo.getNo());
			
			vo.getRewardList().add(rewardVo);
		}
		
		return map.get(projectNo);
	}

	public int approve(String projectNo) {
		return dao.approve(sst, projectNo);
	}

	public int reject(String projectNo) {
		return dao.reject(sst, projectNo);
	}

	public List<ProjectVo> search(ProjectSearchVo vo) {
		return dao.search(sst, vo);
	}

	
}
