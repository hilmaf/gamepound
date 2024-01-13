package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.service.ProjectServiceHJY;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;
import com.gamepound.app.settlement.vo.SettlementVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectControllerHJY {
	
	/**
	 * 현지연 프로젝트 컨트롤러
	 * */
	
	private final ProjectServiceHJY service;
	
	// 작성중 프로젝트 조회
	@PostMapping("getCurrentProject")
	public List<ProjectVo> getCurrentProject(@RequestBody MemberVo vo) {
		List<ProjectVo> voList = service.getCurrentProject(vo);
		return voList;
	}
	
	// 프로젝트 올리기 (카테고리 저장 및 insert)
	@PostMapping("create/new")
	public Map<String, String> newProject(@RequestBody ProjectVo vo) throws Exception {
		
		Map<String, String> resultMap = service.newProject(vo);
		
		return resultMap;
		
	}
	
	// 프로젝트 내용 조회 (메인) 프로젝트 넘버필요
	@GetMapping("create/main")
	public Map<String, Object> createMain(ProjectVo vo) {
		System.out.println(vo);
		Map<String, Object> map = service.createMain(vo);
		System.out.println(map.get("mainVo"));
		return map;
	}
	
	// 프로젝트 작성조회 : 기본정보 프로젝트 넘버필요
	@GetMapping("get/basic")
	public ProjectVo getBasic(ProjectVo vo) {
		
		ProjectVo projectVo = service.getBasic(vo);
		System.out.println("기본정보 : " + projectVo);
		
		return projectVo;
		
	}
	// 프로젝트 작성저장 : 기본정보
	@PostMapping("save/basic")
	public void saveBasic(ProjectVo vo) throws Exception {
		System.out.println(vo);
		int result = service.saveBasic(vo);
		if(result != 1) {
			throw new Exception("프로젝트 기본정보 작성에 실패했습니다.");
		}
		System.out.println("프로젝트 작성저장 결과 : " + result);
		
	}
	
	
	// 프로젝트 작성조회 : 펀딩계획 프로젝트 넘버필요
	@GetMapping("get/plan")
	public void getPlan(ProjectVo vo) {
		
		ProjectVo projectVo = service.getPlan(vo);
		System.out.println("펀딩계획 : " + projectVo);
		
	}
	// 프로젝트 작성저장 : 펀딩계획
	@PostMapping("save/plan")
	public void savePlan(ProjectVo vo) throws Exception {
		
		int result = service.savePlan(vo);
		if(result != 1) {
			throw new Exception("프로젝트 펀딩계획 작성에 실패했습니다.");
		}
		System.out.println("프로젝트 펀딩계획 결과 : " + result);
		
	}
	
	
	// 프로젝트 작성조회 : 선물구성 프로젝트 넘버필요
	@GetMapping("get/reword")
	public void getReword(ProjectVo vo) {
		
		List<RewardVo> projectVo = service.getReword(vo);
		System.out.println("선물 : " + projectVo);
		
	}
	// 프로젝트 작성 : 선물구성
	@PostMapping("create/reword")
	public void createReword(RewardVo vo) throws Exception {
		
		int result = service.createReword(vo);
		if(result != 1) {
			throw new Exception("선물추가에 실패했습니다.");
		}
		System.out.println("선물추가 결과 : " + result);
		
	}
	// 프로젝트 작성저장 : 선물구성
	@PostMapping("save/reword")
	public void saveReword(RewardVo vo) throws Exception {
		
		int result = service.saveReword(vo);
		if(result != 1) {
			throw new Exception("선물저장에 실패했습니다.");
		}
		System.out.println("선물저장 결과 : " + result);
		
	}
	// 프로젝트 선물삭제 : 선물구성
	@PostMapping("delete/reword")
	public void deleteReword(RewardVo vo) throws Exception {
		
		int result = service.deleteReword(vo);
		if(result != 1) {
			throw new Exception("선물삭제에 실패했습니다.");
		}
		System.out.println("선물삭제 결과 : " + result);
		
	}
	
	
	// 프로젝트 작성조회 : 프로젝트 계획 프로젝트 넘버필요
	@GetMapping("get/dateplan")
	public void getDateplan(ProjectVo vo) {
		
		ProjectVo projectVo = service.getDateplan(vo);
		System.out.println("프로젝트 계획 : " + projectVo);
		
	}
	// 프로젝트 작성저장 : 프로젝트 계획 작성시 TODO-현지연 : 이미지 업로드 메소드 추가 : 선생님이 갤러리 할 시 만들어야함
	// 프로젝트 작성저장 : 프로젝트 계획
	@PostMapping("save/dateplan")
	public void saveDateplan(ProjectVo vo) throws Exception {
		
		int result = service.saveDateplan(vo);
		if(result != 1) {
			throw new Exception("프로젝트 계획 작성에 실패했습니다.");
		}
		System.out.println("프로젝트 계획 작성 결과 : " + result);
		
	}
	
	
	// 프로젝트 작성조회 : 창작자 정보 프로젝트 넘버필요
	@GetMapping("get/userinfo")
	public void getUserinfo(ProjectVo vo) {
		SettlementVo settlementVo = service.getUserinfo(vo);
		System.out.println("창작자 정보 : " + settlementVo);
	}
	// 프로젝트 작성저장 : 창작자 정보
	@PostMapping("save/userinfo")
	public void saveUserinfo(SettlementVo vo) throws Exception {
		
		int result = service.saveUserinfo(vo);
		if(result != 1) {
			throw new Exception("창작자 정보 작성(저장)에 실패했습니다.");
		}
		System.out.println("창작자 정보 작성(저장) 결과 : " + result);
		
	}
	
}
