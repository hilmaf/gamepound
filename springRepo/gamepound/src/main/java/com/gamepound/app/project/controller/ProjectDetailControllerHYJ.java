package com.gamepound.app.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.service.ProjectServiceHYJ;
import com.gamepound.app.project.vo.ProjectCommunityVo;
import com.gamepound.app.project.vo.ProjectDetailCntVo;
import com.gamepound.app.project.vo.ProjectDetailVo;
import com.gamepound.app.project.vo.ProjectStoryVo;
import com.gamepound.app.project.vo.ProjectUpdateVo;
import com.gamepound.app.project.vo.ProjectVo;

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
	
	//프로젝트 상세 조회 - 로그인회원 후원 목록
	@GetMapping("check")
	public MemberVo checkBack(MemberVo vo) {
		MemberVo loginMemberVo = service.checkBack(vo);
		return loginMemberVo;
	}
	
	//프로젝트 상세 조회 - 프로젝트 계획
	@GetMapping("story")
	public ProjectStoryVo projectDetailStory(String no) {
		ProjectStoryVo detailStoryVo = service.projectDetailStory(no);
		return detailStoryVo;
	}
	
	//프로젝트 상세 조회 - 업데이트
	@GetMapping("update")
	public Map<String, Object> projectDetailUpdate(String no) {
		Map<String, Object>map = service.projectDetailUpdate(no);
		return map;
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
	public Map<String, Object> projectDetailPrelaunchUpdate(String no) {
		Map<String, Object>map = service.projectDetailUpdate(no);
		return map;
	}
	
	
	//////////////////////////////////////////////////////////////
	//프로젝트 상세 조회 - 업데이트 작성
	@PostMapping("update/save")
	public Map<String, String> projectDetailUpdate(@RequestBody ProjectUpdateVo vo) throws Exception {
		log.info("vo ::: {}",vo);
		int result = service.projectDetailUpdate(vo);
		Map<String, String>map = new HashMap<String, String>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}

		return map;
	}

	//----------------------------------------------------------------------------------//
	// 프로젝트 계획 이미지 업로드
	@PostMapping("update/save/image")
	public Map<String, String> saveImage(@RequestPart MultipartFile img, HttpServletRequest req) throws Exception {
		
		// 파일저장 service
		String uploadDir = "/resources/images/projectUpdateImg/";
	    String root = req.getServletContext().getRealPath(uploadDir); // 저장경로
	    String fileName = null;
	    if(!(img == null) && !(img.isEmpty())) { // 이미지 파일 처리
	    	fileName = service.imagefileSave(img, root);        	
	    }
	    
	    // 결과
	    String resultFileName = "http://localhost:8889/gamepound" + uploadDir + fileName;
	    Map<String, String> map = new HashMap<>();
	    map.put("msg", "good");
	    map.put("fileUrl", resultFileName);
	    if(fileName == null) {
	    	map.put("msg", "bad");
	    }
		
		return map;
	}
	//----------------------------------------------------------------------------------//
	
	
	
	
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
	public Map<String, String> projectDetailPrelaunchUpdate(@RequestBody ProjectUpdateVo vo) {
		int result = service.projectDetailUpdate(vo);
		Map<String, String>map = new HashMap<String, String>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}

		return map;
	}
	
}