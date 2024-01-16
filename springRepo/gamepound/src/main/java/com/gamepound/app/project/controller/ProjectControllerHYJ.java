package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.ProjectServiceHYJ;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectControllerHYJ {
	private final ProjectServiceHYJ service;
	
	//목록 조회 - 카테고리(소분류)
	@GetMapping("list/category")
	public List<ProjectVo> projectListCategory(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListCategory(vo);
		
		//TODO-HYJ : [list-category] ajaxㄱㄱ (화면에서 받을때 : 달성률 시작 + 끝, 카테고리번호(필수) , 프로젝트 상태 받을수있음)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo.getNo() + " ::: " + projectVo);
		}
		return voList;
	}
	
	//목록 조회 - 인기순
	@GetMapping("list/popular")
	public List<ProjectVo> projectListPopular(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListPopular(vo);
		
		//TODO-HYJ : [list-popular] ajax.....(화면에서 받을때 : 달성률 시작 + 끝 받을수있음)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
		
		return voList;
	}
	
	//목록 조회 - 신규
	@GetMapping("list/new")
	public List<ProjectVo> projectListNew(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListNew(vo);
		
		//TODO-HYJ : [list-new] ajax (화면에서 받을때 : 달성률 시작 + 끝)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
		return voList;
	}
	
	
	//목록 조회 - 마감임박
	@GetMapping("list/imminent")
	public List<ProjectVo> projectListImminent(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListImminent(vo);
		
		//TODO-HYJ : [list-imminent] ajax (화면에서 받을때 : 달성률 시작 + 끝)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
		return voList;
	}
	
	
	//목록 조회 - 공개예정
	@GetMapping("list/prelaunch")
	public List<ProjectVo> projectListPrelaunch() {
		List<ProjectVo> voList = service.projectListPrelaunch();
		
		//TODO-HYJ : [list-prelaunch] ajax처리
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
		return voList;
	}
	
	
	
}
