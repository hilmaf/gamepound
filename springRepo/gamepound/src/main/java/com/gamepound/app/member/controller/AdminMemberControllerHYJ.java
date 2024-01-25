package com.gamepound.app.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Map<String, Object> memberList(MemberVo vo, String pageNum) {
		Map<String, Object> map = service.memberList(vo, pageNum);
		return map;
	}
	
	//검색
	@PostMapping
	public Map<String, Object> searchMemberList(@RequestBody MemberVo vo, String pageNum) {
		Map<String, Object> map = service.memberList(vo, pageNum);
		return map;
	}
	
	//상세
	@GetMapping("detail")
	public MemberVo memberDetail(MemberVo vo) {
		MemberVo detailVo = service.memberDetail(vo);
		
		return detailVo;
	}
	
	//수정
	@PutMapping("edit")
	public ResponseEntity<String> memberEdit(@RequestBody MemberVo vo) {
		int result = service.memberEdit(vo);
		
		if(result != 1) {
			return ResponseEntity.ok("bad");
		}
		return ResponseEntity.ok("good");
	}
	
}
