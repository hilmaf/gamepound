package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.service.ProjectServiceHYJ;
import com.gamepound.app.project.vo.ProjectListVo;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectControllerHYJ {
	private final ProjectServiceHYJ service;
	
	//목록 조회 - 카테고리(소분류)
	@GetMapping("list/category")
	public void projectListCategory(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListCategory(vo);
		
		//TODO-HYJ : ajaxㄱㄱ (화면에서 받을때 : 달성률 시작 + 끝, 카테고리번호(필수) , 프로젝트 상태 받을수있음)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
	}
	
	//목록 조회 - 인기순
	@GetMapping("list/popular")
	public void projectListPopular(ProjectListVo vo) {
		List<ProjectVo> voList = service.projectListPopular(vo);
		
		//TODO-HYJ : ajax.....(화면에서 받을때 : 달성률 시작 + 끝 받을수있음)
		for (ProjectVo projectVo : voList) {
			System.out.println(projectVo);
		}
	}
	
	//목록 조회 - 신규
	
	
	//목록 조회 - 마감임박
	
	
	//목록 조회 - 공개예정
	
	
	
}
