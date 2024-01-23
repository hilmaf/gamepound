package com.gamepound.app.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.page.vo.PageVo;
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
	
	public Map<String, Object> list(String currentPage_) {
		String cnt = dao.cntProjects(sst);
		
		int listCount = Integer.parseInt(cnt);
		if(currentPage_ == null) {
			currentPage_ = "1";
		}
		int currentPage = Integer.parseInt(currentPage_);
		int pageLimit = 5;
		int boardLimit = 10;
		
		PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
		
		List<ProjectVo> projectList = dao.list(sst, pvo);
		
		Map<String, Object> listMap = new HashMap<>();
		listMap.put("cnt", cnt);
		listMap.put("projectList", projectList);
		
		return listMap;
	}

	public ProjectDetailVo detail(String projectNo) {
		List<ProjectDetailVo> list = dao.detail(sst, projectNo);

		// 프로젝트 정보 담기
		Map<String, ProjectDetailVo> map = new HashMap<String, ProjectDetailVo>();
		for(ProjectDetailVo vo : list) {
			map.put(vo.getNo(), vo);
		}
		
		// 선물 정보 담기
		for(ProjectDetailVo vo : list) {
			RewardVoLKM rewardVo = new RewardVoLKM();
			rewardVo.setRewardNo(vo.getRewardNo());
			rewardVo.setRewardName(vo.getRewardName());
			rewardVo.setRewardAmount(vo.getRewardAmount());
			rewardVo.setProjectNo(vo.getNo());
			
			ProjectDetailVo target = map.get(vo.getNo());
			if(target.getRewardList() != null) {
				target.getRewardList().add(rewardVo);
			}
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
