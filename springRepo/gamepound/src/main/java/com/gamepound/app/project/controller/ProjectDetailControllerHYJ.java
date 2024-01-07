package com.gamepound.app.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.project.service.ProjectServiceHYJ;
import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("project/detail")
@RequiredArgsConstructor
public class ProjectDetailControllerHYJ {
	private final ProjectServiceHYJ service;
	
	//프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("story")
	public void projectDetailStory(ProjectDetailVo vo) {
		Map<String, Object> map = service.projectDetailStory(vo);
		System.out.println(map.get("projectDetail"));
		System.out.println(map.get("projectStory"));
	}
	
	//프로젝트 상세 조회 - 업데이트
	@GetMapping("update")
	public void projectDetailUpdate(ProjectDetailVo vo) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(vo);
		System.out.println(voList);
	}
	
	//프로젝트 상세 조회 - 커뮤니티
	@GetMapping("community")
	public void projectDetailCommunity(ProjectDetailVo vo) {
		List<ProjectCommunityVo>voList = service.projectDetailCommunity(vo);
		System.out.println(voList);
	}
	
	//공개예정 프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("prelaunch/story")
	public void projectDetailPrelaunchStory(ProjectDetailVo vo) {
		Map<String, Object>map = service.projectDetailStory(vo);
		System.out.println(map.get("projectDetail"));
		System.out.println(map.get("projectStory"));
	}
	
	//공개예정 프로젝트 상세 조회 - 업데이트
	@GetMapping("prelaunch/update")
	public void projectDetailPrelaunchUpdate(ProjectDetailVo vo) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(vo);
		System.out.println(voList);
	}
}
