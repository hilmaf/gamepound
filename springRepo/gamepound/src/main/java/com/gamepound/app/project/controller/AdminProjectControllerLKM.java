package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.AdminProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectSearchVo;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("admin/project")
@RequiredArgsConstructor
public class AdminProjectControllerLKM {

	private final AdminProjectServiceLKM service;
	
	// 프로젝트 목록 조회
	@GetMapping("")
	public List<ProjectVo> list() {
		List<ProjectVo> projectList = service.list();
		
		return projectList;
	}
	
	// 프로젝트 상세 조회
	@GetMapping("detail")
	public ProjectDetailVo detail(String projectNo) {
		ProjectDetailVo detailVo = service.detail(projectNo);
		
		return detailVo;
	}
	
	// 프로젝트 승인 처리
	@PostMapping("approve")
	public Map<String, String> approve(String projectNo) {
		int result = service.approve(projectNo);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "good");
		
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}

	
	// 프로젝트 반려 처리
	@PostMapping("reject")
	public Map<String, String> reject(String projectNo) {
		int result = service.reject(projectNo);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "good");
		
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}

	// 프로젝트 검색
	@PostMapping("search")
	public void search(ProjectSearchVo vo) {
		List<ProjectVo> searchedList = service.search(vo);
	}
}
