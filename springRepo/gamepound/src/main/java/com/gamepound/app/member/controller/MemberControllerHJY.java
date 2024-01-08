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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberControllerHJY {

	private final MemberServiceHJY service;
	private final MailSendService mailService;
	
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
	@GetMapping("mailCheck")
	public void mailCheck(MemberVo vo, HttpSession session) {
		System.out.println(vo);
		int verificationCode = mailService.joinEmail(vo.getEmail());
		session.setAttribute("verificationCode", verificationCode); // 인증번호 세션에 저장
		System.out.println(session.getAttribute("verificationCode"));
	}
	
	// 인증번호 입력
	@PostMapping("mailauthCheck")
    public void AuthCheck(String userCode, HttpSession session){
		
		int verificationCode = (int) session.getAttribute("verificationCode");
		
		// 세션에서 실패 횟수 가져오기
	    Integer failureCount = (Integer) session.getAttribute("failureCount");
	    if (failureCount == null) {
	        failureCount = 0;
	    }
		
		if(verificationCode == Integer.parseInt(userCode)) {
			System.out.println("인증성공");
	        session.removeAttribute("failureCount"); // 인증 성공 시 실패 횟수 초기화
			session.invalidate();
		} else {
			System.out.println("인증실패");
			
			// 실패 횟수 증가
	        failureCount++;
	        session.setAttribute("failureCount", failureCount);

	        // 일정 횟수 이상 실패하면 세션 무효화
	        if (failureCount >= 3) {
	            System.out.println("세션 무효화 (연속 3회 실패)");
	            session.invalidate();
	        }
		}
    }
	
	// 아이디 중복검사
	@PostMapping("emailUnique")
	public void isEmailUnique(MemberVo vo) throws Exception {
		int result = service.isEmailUnique(vo);
		if(result >= 1) {
			System.out.println("이미 가입된 이메일입니다.");
			throw new Exception("이미 가입된 이메일입니다.");// TODO-현지연 : 가입된 이메일 메세지 띄우기
		}
		System.out.println("이 계정으로 가입하실 수 있습니다.");
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
