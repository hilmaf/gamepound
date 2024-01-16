package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		Map<String, Object> map = service.createMain(vo);
		return map;
	}
	
	// 프로젝트 작성저장 : 기본정보
	@PostMapping("save/basic")
	public Map<String, String> saveBasic(
			@RequestParam("title") String title,
			@RequestPart(name = "imageUrl", required = false) MultipartFile imageUrl,
	        @RequestParam("mainCategoryNo") String mainCategoryNo,
	        @RequestParam("subCategoryNo") String subCategoryNo,
	        @RequestParam("no") String no,
	        HttpServletRequest req) throws Exception {
		
		// 파일저장 service
		String uploadDir = "/resources/images/projectImg/";
        String root = req.getServletContext().getRealPath(uploadDir); // 저장경로
        String fileName = null;
        if(!(imageUrl == null) && !(imageUrl.isEmpty())) { // 이미지 파일 처리
        	fileName = service.imagefileSave(imageUrl, root);        	
        }
		
		ProjectVo vo = new ProjectVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setMainCategoryNo(mainCategoryNo);
		vo.setCategoryNo(subCategoryNo);
		vo.setImageUrl(fileName);
		
		int result = service.saveBasic(vo);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	// 프로젝트 작성조회 : 펀딩계획 프로젝트 넘버필요
	@GetMapping("get/plan")
	public Map<String, Object> getPlan(ProjectVo vo) {
		
		ProjectVo projectVo = service.getPlan(vo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("vo", projectVo);
		map.put("msg", "good");
		
		if(projectVo == null) {
			map.put("msg", "bad");
		}
		
		return map;
		
	}
	// 프로젝트 작성저장 : 펀딩계획
	@PostMapping("save/plan")
	public Map<String, String> savePlan(@RequestBody ProjectVo vo) throws Exception {
		
		int result = service.savePlan(vo);

		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	
	// 프로젝트 작성조회 : 선물구성 프로젝트 넘버필요
	@GetMapping("get/reward")
	public Map<String, Object> getReword(ProjectVo vo) {
		
		List<RewardVo> voList = service.getReward(vo);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "good");
		map.put("voList", voList);
		if(voList == null) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	// 프로젝트 작성 : 선물구성
	@PostMapping("create/reword")
	public Map<String, String> createReword(@RequestBody RewardVo vo) throws Exception {
		System.out.println("제대로잘오나 선물작성" + vo);
		int result = service.createReword(vo);
		
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
		
	}
	// 프로젝트 작성저장 : 선물구성
	@PostMapping("save/reword")
	public Map<String, String> saveReword(@RequestBody RewardVo vo) throws Exception {
		System.out.println("제대로잘오나 선물수정" + vo);
		int result = service.saveReword(vo);
		
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
		
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
