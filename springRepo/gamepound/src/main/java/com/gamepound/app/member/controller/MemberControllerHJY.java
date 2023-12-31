package com.gamepound.app.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamepound.app.member.service.MemberServiceHJY;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberControllerHJY {
	
	private final MemberServiceHJY service;
	
	// 로그인 처리
	@PostMapping("login")
	public void login(MemberVo vo, HttpSession session) {
		
		MemberVo loginMember = service.login(vo);
		if(loginMember == null) {
			System.out.println("그런 아이디없음"); // TODO: 로그인실패 메세지
		} else {
			session.setAttribute("loginMember", loginMember);
			System.out.println(loginMember);
		}
		
	}
	
	// 회원가입 처리
	
	// 비밀번호 재설정 처리
	
	// 회원탈퇴 처리
	
}
