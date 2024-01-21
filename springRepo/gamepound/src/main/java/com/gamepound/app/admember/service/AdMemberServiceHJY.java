package com.gamepound.app.admember.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.admember.dao.AdMemberDaoHJY;
import com.gamepound.app.admember.vo.AdMemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdMemberServiceHJY {
	
	private final AdMemberDaoHJY dao;
	private final SqlSessionTemplate sst;
	private final BCryptPasswordEncoder encoder;
	
	// 로그인
	public AdMemberVo login(AdMemberVo vo) {
		
		log.info("전달받은 vo값 : {}", vo);
		
		AdMemberVo dbVo = dao.login(sst, vo);
		log.info("dbVo : {}", dbVo);
		
		// 아이디, 비밀번호 없을시
		if(dbVo == null) {
			return null;
		}
		// 암호화 비밀번호 비교
		boolean isOk = encoder.matches(vo.getPwd(), dbVo.getPwd());
		if(!isOk) {
			return null;
		}
		
		return dbVo;
	}

}
