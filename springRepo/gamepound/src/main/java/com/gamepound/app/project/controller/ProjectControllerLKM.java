package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.ProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.project.vo.ProjectListVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
@CrossOrigin("*")
public class ProjectControllerLKM {

	private final ProjectServiceLKM service;
	
	@PostMapping("search")
	public List<ProjectBriefVo> searchProject(@RequestBody ProjectListVo vo) {
		System.out.println(1);
		List<ProjectBriefVo> searchList = service.searchProject(vo);
	
		return searchList; 
	}

}
