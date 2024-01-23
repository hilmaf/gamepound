package com.gamepound.app.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.member.service.AdminMemberServiceHYJ;
import com.gamepound.app.member.service.MemberServiceHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("admin/user")
@RequiredArgsConstructor
@Slf4j
public class AdminMemberControllerHYJ {
	private final AdminMemberServiceHYJ service;
	
	@GetMapping
	public void memberList(MemberVo vo) {
		List<MemberVo> voList = service.memberList(vo);
		for (MemberVo memberVo : voList) {
			System.out.println(memberVo);
		}
	}
	
	@GetMapping("detail")
	public void memberDetail(MemberVo vo) {
		MemberVo detailVo = service.memberDetail(vo);
		
		System.out.println(vo);
	}
}
