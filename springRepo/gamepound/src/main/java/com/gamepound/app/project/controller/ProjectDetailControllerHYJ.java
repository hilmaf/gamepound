package com.gamepound.app.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void projectDetailStory(String no) {
		Map<String, Object> map = service.projectDetailStory(no);
		System.out.println(map.get("projectDetail"));
		System.out.println(map.get("projectStory"));
	}
	
	//프로젝트 상세 조회 - 업데이트
	@GetMapping("update")
	public void projectDetailUpdate(String no) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(no);
		System.out.println(voList);
	}
	
	//프로젝트 상세 조회 - 커뮤니티
	@GetMapping("community")
	public void projectDetailCommunity(String no) {
		List<ProjectCommunityVo>voList = service.projectDetailCommunity(no);
		System.out.println(voList);
	}
	
	//공개예정 프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("prelaunch/story")
	public void projectDetailPrelaunchStory(String no) {
		Map<String, Object>map = service.projectDetailStory(no);
		System.out.println(map.get("projectDetail"));
		System.out.println(map.get("projectStory"));
	}
	
	//공개예정 프로젝트 상세 조회 - 업데이트
	@GetMapping("prelaunch/update")
	public void projectDetailPrelaunchUpdate(String no) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(no);
		System.out.println(voList);
	}
	
	//프로젝트 상세 조회 - 업데이트 작성
	@PostMapping("update")
	public void projectDetailUpdate(ProjectUpdateVo vo) throws Exception {
		int result = service.projectDetailUpdate(vo);
		if(result != 1) {
			System.out.println("[프로젝트 업데이트 작성] 실패");
		}
		System.out.println("[프로젝트 업데이트 작성] 성공");
	}
	
	//프로젝트 상세 조회 - 커뮤니티 작성
	@PostMapping("community")
	public void projectDetailCommunity(ProjectCommunityVo vo) {
		int result = service.projectDetailCommunity(vo);
		if(result != 1) {
			System.out.println("[프로젝트 커뮤니티 작성] 실패");
		}
		System.out.println("[프로젝트 커뮤니티 작성] 성공");
	}
	
	
	
}
