package com.gamepound.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
		System.out.println(vo);
		MemberVo loginMember = service.login(vo);
		System.out.println(loginMember);
		
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
	public void join(MemberVo vo) throws Exception {
		int result = service.join(vo);
		if(result != 1) {
			// TODO-현지연 : 회원가입 검증로직 실패 메세지 띄우기
		}
		System.out.println("회원가입 성공");
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
	
	// 비밀번호 찾기 : 이메일, 비밀번호 재확인
	@PostMapping("confirmPassword")
	public String confirmPassword(MemberVo vo, HttpSession session) {
		int result = service.confirmPassword(vo);
		if(result != 1) {
			System.out.println("아이디, 비밀번호 확인 실패");
		}
		
		System.out.println("새 비밀번호 입력창으로 통과");
		// 이메일, 비밀번호 세션에 저장
		Map<String, String> confirmInfo = new HashMap<String, String>();
		confirmInfo.put("confirmEmail", vo.getEmail());
		confirmInfo.put("confirmPwd", vo.getPwd());
		session.setAttribute("confirmInfo", confirmInfo);
		System.out.println(confirmInfo);
		return "redirect:/member/resetPassword";
	}
		
	// 비밀번호 재설정 처리
	@PostMapping("resetPassword")
	public String resetPassword(MemberVo vo, HttpSession session) throws Exception {
		Map<String, String> confirmInfo = (Map<String, String>) session.getAttribute("confirmInfo");
		if(confirmInfo != null) {
			vo.setEmail(confirmInfo.get("confirmEmail"));			
		}
		
		int result = service.resetPassword(vo);
		if(result != 1) {
			System.out.println("비밀번호 재설정 실패");
			throw new Exception("비밀번호 재설정 실패");
		} 
		System.out.println("비밀번호 재설정 완료");
		session.invalidate();
		return "redirect:/member/login";
	}
	
	// 회원탈퇴 처리
	@PostMapping("quit")
	public void quit(MemberVo vo) {
		int result = service.quit(vo);
		if(result != 1) {
			System.out.println("회원탈퇴 실패");
		}
		System.out.println("회원탈퇴 성공");
	}
	
}
