package com.gamepound.app.admember.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.admember.vo.AdMemberVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AdMemberDaoHJY {

	// 로그인
	public AdMemberVo login(SqlSessionTemplate sst, AdMemberVo vo) {
		log.info("전달받은 vo값 : {}", vo);
		return sst.selectOne("AdMemberMapper.login", vo);
	}

}
