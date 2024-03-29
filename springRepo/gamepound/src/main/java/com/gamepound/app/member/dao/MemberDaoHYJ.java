package com.gamepound.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class MemberDaoHYJ {
	
	//비밀번호 체크
	public MemberVo checkPwd(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberSettingsMapper.checkPwd", vo);
	}
	
	//로그인 유저 프로필 정보
	public MemberVo getProfile(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberSettingsMapper.getProfile", vo);
	}

	//프로필 사진 변경
	public int editPic(MemberVo vo, SqlSessionTemplate sst) {
		return sst.update("MemberSettingsMapper.editPic", vo);
	}

	//프로필 이름 변경
	public int editName(MemberVo vo, SqlSessionTemplate sst) {
		return sst.update("MemberSettingsMapper.editName", vo);
	}

	//프로필 소개 변경
	public int editIntro(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberSettingsMapper.editIntro", vo);
	}

	//프로필 웹사이트 변경
	public int editSiteUrl(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberSettingsMapper.editSiteUrl", vo);
	}

	//프로필 비밀번호 변경
	public int editPwd(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberSettingsMapper.editPwd", vo);
	}

	//변경된  로그인 정보 가져오기
	public MemberVo newLoginData(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("MemberSettingsMapper.getNewLoginData", vo);
	}






}
