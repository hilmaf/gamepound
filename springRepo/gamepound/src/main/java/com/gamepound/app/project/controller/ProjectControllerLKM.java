package com.gamepound.app.project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.ProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
@CrossOrigin("*")
public class ProjectControllerLKM {

	private final ProjectServiceLKM service;
	
	@GetMapping("search")
	public List<ProjectVo> searchProject(@RequestParam String query) {
		List<ProjectVo> searchList = service.searchProject(query);
		
		
		return searchList; 
	}

}
