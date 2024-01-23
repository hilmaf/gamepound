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
	
	//목록
	@GetMapping
	public void memberList(MemberVo vo) {
		log.info("시작");
		List<MemberVo> voList = service.memberList(vo);
		for (MemberVo memberVo : voList) {
			log.info("memberVo ::: {}",memberVo);
			
		}
	}
	
	//상세
	@GetMapping("detail")
	public void memberDetail(MemberVo vo) {
		System.out.println(vo);
		MemberVo detailVo = service.memberDetail(vo);
		
		log.info("detailVo ::: {}" , detailVo);
	}
	
	//수정
	@PostMapping("edit")
	public void memberEdit(MemberVo vo) {
		int result = service.memberEdit(vo);
		
		log.info("result ::: {}", result);
	}
	
	//삭제
	@GetMapping("delete")
	public void memberDelete(MemberVo vo) {
		int result = service.memberDelete(vo);
		
		log.info("result ::: {}", result);
	}
}
