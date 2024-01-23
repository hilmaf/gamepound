package com.gamepound.app.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.back.service.AdminBackServiceHYJ;
import com.gamepound.app.back.vo.AdminBackVo;
import com.gamepound.app.member.controller.AdminMemberControllerHYJ;
import com.gamepound.app.member.service.AdminMemberServiceHYJ;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("admin/back")
@RequiredArgsConstructor
@Slf4j
public class AdminBackControllerHYJ {
	private final AdminBackServiceHYJ service;
	
	//목록
	@GetMapping
	public void backList() {
		List<AdminBackVo>voList = service.backList();
		
		for (AdminBackVo adminBackVo : voList) {
			System.out.println(adminBackVo);
		}
	}
	
	//상세
	@GetMapping("detail")
	public void backDetail(AdminBackVo vo) {
		AdminBackVo detailVo = service.backDetail(vo);
		
		System.out.println(detailVo);
	}
	
}
