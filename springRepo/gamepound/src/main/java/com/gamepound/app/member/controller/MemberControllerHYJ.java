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
		System.out.println(vo);
		
		int result = service.editPic(vo);
		
		if(result != 1) {
			System.out.println("[MSP-C]사진 변경 실패");
			throw new Exception();
		}
		
		//TODO-HYJ : [setting-pic]syso말고 화면 변경해야함
		System.out.println("[MSP-C]사진 변경 성공");
	}
	
	//이름 변경
	
	//소개 변경
	
	//웹사이트 변경
	
	//이메일 변경
	
	//비밀번호 변경
	
}
