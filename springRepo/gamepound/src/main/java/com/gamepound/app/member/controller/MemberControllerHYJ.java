package com.gamepound.app.member.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.member.service.MemberServiceHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("settings")
@RequiredArgsConstructor
public class MemberControllerHYJ {

	private final MemberServiceHYJ service;
	private final Map<String, String>map;
	
	//로그인 유저 프로필 정보
	@PostMapping
	public MemberVo getProfile(@RequestBody MemberVo vo) {
		System.out.println("MemberControllerHYJ > getProfile > vo ::: " + vo);
		MemberVo loginMemberVo = service.getProfile(vo);
		System.out.println("MemberControllerHYJ > getProfile > loginMember ::: " + loginMemberVo);
		return loginMemberVo;
	}
	
	//프로필 사진 변경
	@PostMapping("pic")
	public void editPic(@RequestBody MemberVo vo) throws Exception {
		
		int result = service.editPic(vo);
		
		if(result != 1) {
			System.out.println("[MSP-C]사진 변경 실패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-pic]syso말고 ajax해야함
		System.out.println("[MSP-C]사진 변경 성공");
	}
	
	//프로필 이름 변경
	@PostMapping("name")
	public Map<String, String> editName(@RequestBody MemberVo vo) throws Exception {
		System.out.println("MemberControllerHYJ > editName > vo::: " + vo);
		int result = service.editName(vo);
		
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	//프로필 소개 변경
	@PostMapping("intro")
	public void editIntro(@RequestBody MemberVo vo) throws Exception {
		System.out.println("MemberControllerHYJ > editIntro > vo::: " + vo);
		int result = service.editIntro(vo);
		
		if(result != 1) {
			System.out.println("[MSI-C]소개 변경 샐패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-intro] syso말고 ajax처리
		System.out.println("[MSI-C]소개 변경 성공");
		
	}
	
	//프로필 웹사이트 변경
	@PostMapping("siteUrl")
	public void editSiteUrl(@RequestBody MemberVo vo) throws Exception {
		System.out.println("MemberControllerHYJ > editSiteUrl > vo::: " + vo);
		int result = service.editSiteUrl(vo);
		
		if(result != 1) {
			System.out.println("[MSS-C]웹사이트 변경 실패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-siteUrl] syso말고 ajax처리ㄱㄱ
		System.out.println("[MSS-C]웹사이트 변경 성공");
	}
	
	//프로필 비밀번호 변경
	@PostMapping("pwd")
	public void editPwd(@RequestBody MemberVo vo) throws Exception {
		int result = service.editPwd(vo);
		
		if(result != 1) {
			System.out.println("[MSP-C]비밀번호 변경 실패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-pwd] syso ㄴㄴ ajax ㄱㄱ
		System.out.println("[MSP-C]비밀번호 변경 성공");
	}
	

	
}
