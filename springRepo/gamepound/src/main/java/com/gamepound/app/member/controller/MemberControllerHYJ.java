package com.gamepound.app.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gamepound.app.member.service.MemberServiceHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("settings")
@RequiredArgsConstructor
@Slf4j
public class MemberControllerHYJ {

	private final MemberServiceHYJ service;
	private final Map<String, String>map;
	
	//비밀번호 체크
	@PostMapping("checkPwd")
	public Map<String, String> checkPwd(@RequestBody MemberVo vo) throws Exception {
		MemberVo checkVo = service.checkPwd(vo);
		map.put("msg", "good");
		if(checkVo==null) {
			map.put("msg", "bad");
		}
		return map;
	}
	
	//로그인 유저 프로필 정보
	@PostMapping
	public MemberVo getProfile(@RequestBody MemberVo vo) {
		MemberVo loginMemberVo = service.getProfile(vo);
		return loginMemberVo;
	}
	
	//프로필 사진 변경
	@PostMapping("pic")
	public Map<String, String> editPic(@ModelAttribute MemberVo vo, @RequestParam("f") MultipartFile f, HttpServletRequest req) throws Exception {
		System.out.println(vo);
		System.out.println(f);
		int result = service.editPic(vo, f, req);
		
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		return map;
	}
	
	//프로필 이름 변경
	@PostMapping("name")
	public Map<String, String> editName(@RequestBody MemberVo vo) throws Exception {
		int result = service.editName(vo);
		
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	//프로필 소개 변경
	@PostMapping("intro")
	public Map<String, String> editIntro(@RequestBody MemberVo vo) throws Exception {
		int result = service.editIntro(vo);
		
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	//프로필 웹사이트 변경
	@PostMapping("siteUrl")
	public Map<String, String> editSiteUrl(@RequestBody MemberVo vo) throws Exception {
		int result = service.editSiteUrl(vo);
		
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	//프로필 비밀번호 변경
	@PostMapping("pwd")
	public Map<String, String> editPwd(@RequestBody MemberVo vo) throws Exception {
		int result = service.editPwd(vo);
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	

	
}
