package com.gamepound.app.member.vo;

import lombok.Data;

@Data
public class MemberVo {
	
	private String no;
	private String name;
	private String email;
	private String pwd;
	private String confirmPwd;
	private String pic;
	private String intro;
	private String siteUrl;
	private String enrollDate;
	private String updateDate;
	private String quitYn;
	
	//검색 가입기간
	private String termStart;
	private String termEnd;
	
}
