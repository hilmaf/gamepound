package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.AdminProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectDetailVo;
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
	public void approve() {
		
	}

	
	// 프로젝트 반려 처리
	@PostMapping("reject")
	public void reject() {
		
	}
}
