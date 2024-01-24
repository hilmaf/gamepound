package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.project.service.AdminProjectServiceLKM;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectSearchVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("admin/project")
@RequiredArgsConstructor
public class AdminProjectControllerLKM {

	private final AdminProjectServiceLKM service;
	
	// 프로젝트 목록 조회
	@GetMapping("")
	public Map<String, Object> list(@RequestParam("currentPage") String currentPage) {
		Map<String, Object> listMap = service.list(currentPage);
		
		return listMap;
	}

	// 카테고리 목록 가져오기
	
	
	// 프로젝트 상세 조회
	@GetMapping("detail")
	public ProjectDetailVo detail(@RequestParam("no") String projectNo) {
		System.out.println(projectNo);
		ProjectDetailVo detailVo = service.detail(projectNo);
		System.out.println(detailVo);
		
		return detailVo;
	}
	
	// 프로젝트 상태 변경
	@GetMapping("update")
	public Map<String, String> approve(@RequestParam("no") String projectNo
									, @RequestParam("statusNo") String statusNo) {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("projectNo", projectNo);
		paramMap.put("statusNo", statusNo);
		
		int result = service.update(paramMap);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "good");
		
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	// 프로젝트 검색
	@PostMapping("search")
	public Map<String, Object> search(@RequestBody ProjectSearchVo vo) {
		Map<String, Object> searchedMap = service.search(vo);
	
		return searchedMap;
	}
}
