package com.gamepound.app.member.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamepound.app.member.service.MailSendService;
import com.gamepound.app.member.service.MemberServiceHJY;
import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.member.vo.UserCodeVo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberControllerHJY {

	private final MemberServiceHJY service;
	private final MailSendService mailService;
	
	private int userCode = 0;
	
	// 로그인 처리
	@PostMapping("login")
	public Map<String, Object> login(@RequestBody MemberVo vo) throws Exception {
		
		MemberVo loginMember = service.login(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("msg", "good");
		map.put("loginMember", loginMember);
		
		if(loginMember == null) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	// 회원가입 처리
	@PostMapping("join")
	public Map<String, String> join(@RequestBody MemberVo vo) throws Exception {

		int result = service.join(vo);
		
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	// 이메일 인증번호 발송
	@PostMapping("mailCheck")
	public Map<String, Object> mailCheck(@RequestBody MemberVo vo, HttpSession session) {
		Map<String, Object> resultMap = mailService.joinEmail(vo.getEmail());
		userCode = (int) resultMap.get("verificationCode");
		return resultMap;
	}
	
	// 인증번호 입력
	@PostMapping("mailauthCheck")
    public Map<String, String> AuthCheck(@RequestBody UserCodeVo userCode, HttpSession session){
		
		Map<String, String> map = new HashMap<>();
		if(this.userCode == Integer.parseInt(userCode.getUserCode())) {
			map.put("msg", "good");
		} else {
			map.put("msg", "bad");
		}
		
		return map;
    }
	
	// 아이디 중복검사
	@PostMapping("emailUnique")
	public Map<String, String> isEmailUnique(@RequestBody MemberVo vo) throws Exception {
		int result = service.isEmailUnique(vo);
		
		Map<String, String> map = new HashMap<>();
		
		map.put("msg", "good");
		if(result >= 1) {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
	// 비밀번호 찾기
	@PostMapping("confirmPassword")
	public Map<String, Object> confirmPassword(@RequestBody MemberVo vo) throws Exception {
		System.out.println(vo);
		Map<String, Object> resultMap = mailService.newPwdEmail(vo.getEmail());
        
		return resultMap;
	}
		
	// 비밀번호 재설정 처리
	@PostMapping("resetPassword")
	public Map<String, String> resetPassword(@RequestBody MemberVo vo) throws Exception {
		
		// vo받아서 service
		Map<String, String> resultMap = service.resetPassword(vo);
		
		return resultMap;
	}
	
	// 회원탈퇴 처리
	@DeleteMapping("quit")
	public void quit(@RequestBody MemberVo vo) {
		int result = service.quit(vo);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "good");
		if(result != 1) {
			map.put("msg", "bad");
		}
	}
	
}
