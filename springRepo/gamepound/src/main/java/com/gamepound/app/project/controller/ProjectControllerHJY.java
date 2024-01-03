package com.gamepound.app.project.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.service.ProjectServiceHJY;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectControllerHJY {
	
	/**
	 * 현지연 프로젝트 컨트롤러
	 * */
	
	private final ProjectServiceHJY service;
	
	// 작성중 프로젝트 조회
	@GetMapping("getCurrentProject")
	public void getCurrentProject(HttpSession session) {
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		
		List<ProjectVo> voList = service.getCurrentProject(loginMember);
		System.out.println(voList);
	}
	
	// 프로젝트 올리기 (카테고리 저장 및 insert)
	@PostMapping("create/new")
	public void newProject(HttpSession session, ProjectVo vo) throws Exception {
		MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
		if(loginMember == null) {
			throw new Exception("로그인 후 이용하실 수 있습니다.");
		}
		
		vo.setMemberNo(loginMember.getNo());
		
		int result = service.newProject(vo);
		System.out.println("프로젝트 올리기 결과 : " + result);
		
	}
	
	// 프로젝트 내용 조회 (메인) 프로젝트 넘버필요
	@GetMapping("create/main")
	public void createMain(ProjectVo vo) {
		Map<String, Object> map = service.createMain(vo);
		
		System.out.println("메인vo : " + map.get("mainVo"));
		System.out.println("기본정보 작성률 : " + map.get("basicPercent"));
		System.out.println("펀딩계획 작성률 : " + map.get("planPercent"));
		System.out.println("선물 작성률 : " + map.get("rewardPercent"));
		System.out.println("프로젝트계획 작성률 : " + map.get("dateplanPercent"));
		System.out.println("창작자 정보 작성률 : " + map.get("userinfoPercent"));
	}
	
	// 프로젝트 작성조회 : 기본정보 프로젝트 넘버필요
	@GetMapping("get/basic")
	public void getBasic(ProjectVo vo) {
		
		ProjectVo projectVo = service.getBasic(vo);
		System.out.println("기본정보 : " + projectVo);
		
	}
	// 프로젝트 작성저장 : 기본정보
	@GetMapping("save/basic")
	public void saveBasic() {}
	
	// 프로젝트 작성조회 : 펀딩계획 프로젝트 넘버필요
	@GetMapping("get/plan")
	public void getPlan(ProjectVo vo) {
		
		ProjectVo projectVo = service.getPlan(vo);
		System.out.println("펀딩계획 : " + projectVo);
		
	}
	// 프로젝트 작성저장 : 펀딩계획
	@GetMapping("save/plan")
	public void savePlan() {}
	
	// 프로젝트 작성조회 : 선물구성 프로젝트 넘버필요
	@GetMapping("get/reword")
	public void getReword(ProjectVo vo) {
		
		List<RewardVo> projectVo = service.getReword(vo);
		System.out.println("선물 : " + projectVo);
		
	}
	// 프로젝트 작성저장 : 선물구성
	@GetMapping("save/reword")
	public void saveReword() {}
	// 프로젝트 선물삭제 : 선물구성
	@GetMapping("delete/reword")
	public void deleteReword() {}
	
	// 프로젝트 작성조회 : 프로젝트 계획 프로젝트 넘버필요
	@GetMapping("get/dateplan")
	public void getDateplan() {}
	// 프로젝트 작성저장 : 프로젝트 계획
	@GetMapping("save/dateplan")
	public void saveDateplan() {}
	
	// 프로젝트 작성조회 : 창작자 정보 프로젝트 넘버필요
	@GetMapping("get/userinfo")
	public void getUserinfo() {}
	// 프로젝트 작성저장 : 창작자 정보
	@GetMapping("save/userinfo")
	public void saveUserinfo() {}
	
}
