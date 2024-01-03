package com.gamepound.app.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.project.service.ProjectServiceHYJ;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectControllerHYJ {
	private final ProjectServiceHYJ service;
	
	//프로젝트 조회
	
}
