package com.gamepound.app.member.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.controller.TokenUtil;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender mailSender;

	// 임의의 6자리 양수를 반환
    public int makeRandomNumber() {
        Random r = new Random();
        String randomNumber = "";
        for(int i = 0; i < 6; i++) {
            randomNumber += Integer.toString(r.nextInt(10));
        }

		int authNumber;
		return authNumber = Integer.parseInt(randomNumber);
    }
	
	// 이메일 인증번호 보내기
	public Map<String, Object> joinEmail(String email) {
		
		int verificationCode = makeRandomNumber();
		
		String setFrom = "guswlsrl12@gmail.com"; // email-config에 설정한 자신의 이메일 주소
		String toMail = email;
		String title = "[gamepound] 이메일 인증번호 입니다."; // 이메일 제목
		String content = "[인증번호] " + verificationCode; // 이메일 내용
		
		Map<String, Object> resultMap = mailSend(setFrom, toMail, title, content);
		
		resultMap.put("verificationCode", verificationCode);
		
		return resultMap;
	}
	
	// 새 비밀번호 작성페이지 이메일로 보내기
	public Map<String, Object> newPwdEmail(String email) {

		// 이메일 토큰으로 변환
        TokenUtil tokenUtil = new TokenUtil();
        String emailToken = TokenUtil.generateToken(email);
		
		String setFrom = "guswlsrl12@gmail.com"; // email-config에 설정한 자신의 이메일 주소
		String toMail = email;
		String title = "[gamepound] 새로운 비밀번호 설정 안내"; // 이메일 제목
		// 이메일 내용
		String content = "[인증번호] "
				+ "url : http://localhost:3000/newPwd?token=" + emailToken; 
		
		Map<String, Object> resultMap = mailSend(setFrom, toMail, title, content);
		
		return resultMap;
	}
	
	// 이메일 전송
    public Map<String, Object> mailSend(String setFrom, String toMail, String title, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        Map<String, Object> map = new HashMap<>();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8"); // 이메일 메시지와 관련된 설정을 수행합니다.
            // true를 전달하여 multipart 형식의 메시지를 지원하고, "utf-8"을 전달하여 문자 인코딩을 설정
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content, true); // 이메일의 내용 설정 두 번째 매개 변수에 true를 설정하여 html 설정으로한다.
            mailSender.send(message);
            map.put("msg", "good");
            System.out.println("메일보내기 성공");
            return map;
        } catch (MessagingException e) { 
        	// 이메일 서버에 연결할 수 없거나, 잘못된 이메일 주소를 사용하거나, 인증 오류가 발생하는 등 오류
            map.put("msg", "bad");
            e.printStackTrace();
            return map;
        }

    }
}
