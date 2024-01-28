package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.ProjectServiceHYJ;
import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailCntVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectStoryVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("project/detail")
@RequiredArgsConstructor
@Slf4j
public class ProjectDetailControllerHYJ {
	
	private final ProjectServiceHYJ service;
	
	//프로젝트 상세 조회 - 타이틀
	@GetMapping
	public Map<String, Object> projectDetail(String no) {
		Map<String, Object>map = service.projectDetail(no);

		return map;
	}
	
	//프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("story")
	public ProjectStoryVo projectDetailStory(String no) {
		ProjectStoryVo detailStoryVo = service.projectDetailStory(no);
		return detailStoryVo;
	}
	
	//프로젝트 상세 조회 - 업데이트
	@GetMapping("update")
	public List<ProjectUpdateVo> projectDetailUpdate(String no) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(no);
		return voList;
	}
	
	//프로젝트 상세 조회 - 커뮤니티
	@GetMapping("community")
	public Map<String, Object> projectDetailCommunity(String no) {
		Map<String, Object>map = service.projectDetailCommunity(no);
		return map;
	}
	
	//공개예정 프로젝트 상세 조회 - 타이틀
	@GetMapping("prelaunch")
	public Map<String, Object> projectDetailPrelaunch(String no) {
		Map<String, Object> map = service.projectDetail(no);
		return map;
	}
	
	//공개예정 프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("prelaunch/story")
	public ProjectStoryVo projectDetailPrelaunchStory(String no) {
		ProjectStoryVo detailPrelaunchStoryVo = service.projectDetailStory(no);
		return detailPrelaunchStoryVo;
	}
	
	//공개예정 프로젝트 상세 조회 - 업데이트
	@GetMapping("prelaunch/update")
	public List<ProjectUpdateVo> projectDetailPrelaunchUpdate(String no) {
		List<ProjectUpdateVo>voList = service.projectDetailUpdate(no);
		return voList;
	}
	
	
	//////////////////////////////////////////////////////////////
	//프로젝트 상세 조회 - 업데이트 작성
	@PostMapping("update")
	public void projectDetailUpdate(@RequestBody ProjectUpdateVo vo) throws Exception {
		int result = service.projectDetailUpdate(vo);
		if(result != 1) {
			System.out.println("[프로젝트 업데이트 작성] 실패");
		}
		System.out.println("[프로젝트 업데이트 작성] 성공");
	}
	
	//프로젝트 상세 조회 - 커뮤니티 작성
	@PostMapping("community")
	public Map<String, String> projectDetailCommunity(@RequestBody ProjectCommunityVo vo) {
		int result = service.projectDetailCommunity(vo);
		Map<String, String>map = new HashMap<String, String>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}

		return map;
	}
	
	//공개예정 프로젝트 상세 조회 - 업데이트 작성
	@PostMapping("prelaunch/update")
	public void projectDetailPrelaunchUpdate(@RequestBody ProjectUpdateVo vo) {
		int result = service.projectDetailUpdate(vo);
		if(result != 1) {
			System.out.println("[프로젝트 업데이트 작성] 실패");
		}
		System.out.println("[프로젝트 업데이트 작성] 성공");
	}
	
}
