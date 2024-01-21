package com.gamepound.app.admember.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.admember.service.AdMemberServiceHJY;
import com.gamepound.app.admember.vo.AdMemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@RestController
public class AdMemberControllerHJY {
	
	private final AdMemberServiceHJY service;
	
	// 로그인
	@PostMapping("login")
	public ResponseEntity<AdMemberVo> login(@RequestBody AdMemberVo vo) {

		log.info("전달받은 vo 값 : {}", vo);
		
		AdMemberVo resultVo = service.login(vo);
		System.out.println(resultVo);
		if (resultVo == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    }
		
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}
	
}
