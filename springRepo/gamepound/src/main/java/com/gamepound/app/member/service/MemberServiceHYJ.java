package com.gamepound.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.dao.MemberDaoHYJ;
import com.gamepound.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceHYJ {
	
	private final MemberDaoHYJ dao;
	private final SqlSessionTemplate sst;

	//프로필 사진 변경
	public int editPic(MemberVo vo) throws Exception {
		System.out.println(vo.getPic());
		if(vo.getPic() == null || vo.getPic()=="") {
			System.out.println("[MSP-S]사진 변경 실패");
			throw new Exception();
		}
		return dao.editPic(vo, sst);
	}
	
}
