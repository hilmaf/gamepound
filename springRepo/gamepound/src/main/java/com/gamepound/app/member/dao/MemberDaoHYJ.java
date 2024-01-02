package com.gamepound.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.member.vo.MemberVo;

@Repository
public class MemberDaoHYJ {

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

}
