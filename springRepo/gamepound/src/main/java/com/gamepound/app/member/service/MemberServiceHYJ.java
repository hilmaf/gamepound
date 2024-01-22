package com.gamepound.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.dao.MemberDaoHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceHYJ {
	
	private final MemberDaoHYJ dao;
	private final SqlSessionTemplate sst;
	private final BCryptPasswordEncoder encoder;
	
	//비밀번호 체크
	public MemberVo checkPwd(MemberVo vo) throws Exception {
		MemberVo dbVo = dao.checkPwd(sst, vo);
		
		//암호화 비밀번호 비교
		boolean isOk = encoder.matches(vo.getPwd(), dbVo.getPwd());
		if(!isOk) {
			dbVo = null;
		}
		
		return dbVo;
	}

	//로그인 유저 프로필 정보
	public MemberVo getProfile(MemberVo vo) {
		MemberVo memberVo = dao.getProfile(sst, vo);
		String localAddr = "http://127.0.0.1:8889/gamepound";
		String path = "/resources/images/memberProfileImg/";
		memberVo.setPic(localAddr + path + memberVo.getPic());
		
		return memberVo; 
	}
	
	////////////////////////////////////////////////////////////////////////////////////

	//프로필 사진 변경
	public int editPic(MemberVo vo) throws Exception {
		if(vo.getPic() == null || vo.getPic()=="") {
			return -1;
		}
		return dao.editPic(vo, sst);
	}

	//프로필 이름 변경
	public int editName(MemberVo vo) throws Exception {
		if(vo.getName() == null || vo.getName()=="") {
			return -1;
		}
		if(!MemberValidation.isValidName(vo.getName())) {
			return -1;
		}
		
		return dao.editName(vo, sst);
	}

	//프로필 소개 변경
	public int editIntro(MemberVo vo) throws Exception {
		if(vo.getIntro() == null || vo.getIntro()=="") {
			return -1;
		}
		
		return dao.editIntro(sst, vo);
	}

	//프로필 웹사이트 변경
	public int editSiteUrl(MemberVo vo) throws Exception {
		if(vo.getSiteUrl() == null || vo.getSiteUrl() == "") {
			return -1;
		}
		
		return dao.editSiteUrl(sst, vo);
	}

	//프로필 비밀번호 변경
	public int editPwd(MemberVo vo) throws Exception {
		if(vo.getPwd() == null || vo.getPwd() == "") {
			return -1;
		}
		// 비밀번호 검증
		if(MemberValidation.isValidPwd(vo.getPwd())) {
			return -1;
		}
		//비밀번호 암호화
		String securityPwd = encoder.encode(vo.getPwd());
		vo.setPwd(securityPwd);
		
		return dao.editPwd(sst, vo);
	}



	
}
