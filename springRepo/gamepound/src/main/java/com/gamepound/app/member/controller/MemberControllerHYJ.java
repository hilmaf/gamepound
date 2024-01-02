package com.gamepound.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.member.service.MemberServiceHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member/settings")
@RequiredArgsConstructor
public class MemberControllerHYJ {

	private final MemberServiceHYJ service;
	
	//프로필 사진 변경
	@PostMapping("pic")
	public void editPic(MemberVo vo) throws Exception {
		
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
	public void editName(MemberVo vo) throws Exception {
		int result = service.editName(vo);
		
		if(result != 1) {
			System.out.println("[MSN-C]이름 변경 실패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-name] syso말고 ajax처리해야함ㅠㅠ
		System.out.println("[MSN-C]이름 변경 성공");
	}
	
	//소개 변경
	@PostMapping("intro")
	public void editIntro(MemberVo vo) throws Exception {
		int result = service.editIntro(vo);
		
		if(result != 1) {
			System.out.println("[MSI-C]소개 변경 샐패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-intro] syso말고 ajax처리
		System.out.println("[MSI-C]소개 변경 성공");
		
	}
	
	//웹사이트 변경
	
	//이메일 변경
	
	//비밀번호 변경
	
}
