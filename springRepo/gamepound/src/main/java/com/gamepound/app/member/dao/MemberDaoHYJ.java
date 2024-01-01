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

}
