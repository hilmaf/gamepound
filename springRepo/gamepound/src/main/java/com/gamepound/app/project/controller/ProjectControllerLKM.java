package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.ProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
public class ProjectControllerLKM {

	private final ProjectServiceLKM service;
	
	@PostMapping("search")
	public void searchProject(@RequestParam String keyword) {
		List<ProjectVo> searchList = service.searchProject(keyword);
		
		System.out.println(searchList);
		
	}

}
