package com.gamepound.app.project.controller;

import java.util.List;
import java.util.Map;

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
	public Map<String, Object> projectListCategory(ProjectListVo vo) {
		return service.projectListCategory(vo);
	}
	
	//목록 조회 - 인기순
	@GetMapping("list/popular")
	public Map<String, Object> projectListPopular(ProjectListVo vo) {
		return service.projectListPopular(vo);
	}
	
	//목록 조회 - 신규
	@GetMapping("list/new")
	public Map<String, Object> projectListNew(ProjectListVo vo) {
		return service.projectListNew(vo);
	}
	
	
	//목록 조회 - 마감임박
	@GetMapping("list/imminent")
	public Map<String, Object> projectListImminent(ProjectListVo vo) {
		return service.projectListImminent(vo);
	}
	
	
	//목록 조회 - 공개예정
	@GetMapping("list/prelaunch")
	public Map<String, Object> projectListPrelaunch() {
		return service.projectListPrelaunch();
	}
}
