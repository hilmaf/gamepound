package com.gamepound.app.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.service.ProjectServiceHJY;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/project/create")
@RequiredArgsConstructor
public class ProjectControllerHJY {
	
	/**
	 * 현지연 프로젝트 컨트롤러
	 * */
	
	private final ProjectServiceHJY service;
	
	// 작성중 프로젝트 조회
	@GetMapping("getCurrentProject")
	public void getCurrentProject(HttpSession session) {
		System.out.println("ff");
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		List<ProjectVo> voList = service.getCurrentProject(loginMember);
		System.out.println(voList);
	}
	
	// 프로젝트 올리기 (카테고리 저장 및 insert)
	
	// 프로젝트 내용 (메인)
	
	// 프로젝트 작성저장 : 기본정보
	
	// 프로젝트 작성저장 : 펀딩계획
	
	// 프로젝트 작성저장 : 선물구성
	
	// 프로젝트 작성저장 : 프로젝트 계획
	
	// 프로젝트 작성저장 : 창작자 정보
	
}
