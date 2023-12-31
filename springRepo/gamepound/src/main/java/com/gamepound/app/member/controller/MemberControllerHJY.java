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
	
	// �α��� ó��
	@PostMapping("login")
	public void login(MemberVo vo, HttpSession session) {
		
		MemberVo loginMember = service.login(vo);
		if(loginMember == null) {
			System.out.println("�׷� ���̵����"); // TODO: �α��ν��� �޼���
		} else {
			session.setAttribute("loginMember", loginMember);
			System.out.println(loginMember);
		}
		
	}
	
	// ȸ������ ó��
	
	// ��й�ȣ �缳�� ó��
	
	// ȸ��Ż�� ó��
	
}
