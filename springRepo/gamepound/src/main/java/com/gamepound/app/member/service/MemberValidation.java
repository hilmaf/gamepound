package com.gamepound.app.member.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberValidation {
	
	private static final Pattern EMAIL_REGEX_PATTERN = Pattern.compile("^[_A-Za-z0-9_\\-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final Pattern PWD_REGEX_PATTERN = Pattern.compile("^.{4,}$");
	private static final Pattern NAME_REGEX_PATTERN = Pattern.compile("^[A-Za-z가-힣()_-ㄱ-ㅎㅏ-ㅣ]{2,14}$");

	// 이메일 검사
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_REGEX_PATTERN.matcher(email);
        return matcher.matches();
    }
    
	// 비밀번호 검사
    public static boolean isValidPwd(String pwd) {
        Matcher matcher = PWD_REGEX_PATTERN.matcher(pwd);
        return matcher.matches();
    }
    
	// 이름 검사
    public static boolean isValidName(String name) {
        Matcher matcher = NAME_REGEX_PATTERN.matcher(name);
        return matcher.matches();
    }
}
