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
	public void login(MemberVo vo, HttpSession session) throws Exception {
		
		MemberVo loginMember = service.login(vo);
		if(loginMember == null) {
			System.out.println("로그인 실패"); // TODO: 로그인실패
		} else {
			session.setAttribute("loginMember", loginMember);
			System.out.println(loginMember);
		}
		
	}
	
	// 회원가입 처리
	@PostMapping("join")
	public void join(MemberVo vo) throws Exception {
		int result = service.join(vo);
		if(result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println(result);
		}
	}
	
	// 아이디 중복검사
	
	
	// 비밀번호 재설정 처리
	
	// 회원탈퇴 처리
	
}
