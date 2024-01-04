package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamepound.app.project.service.ProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProjectControllerLKM {

	private final ProjectServiceLKM service;
	
	@PostMapping("search")
	public void searchProject(String keyword) {
		List<ProjectVo> searchList = service.searchProject(keyword);
		
		System.out.println(searchList);
	}
}
