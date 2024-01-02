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
		if(vo.getPic() == null || vo.getPic()=="") {
			System.out.println("[MSP-S]사진 변경 실패 vo예외 발생");
			throw new Exception();
		}
		return dao.editPic(vo, sst);
	}

	//프로필 이름 변경
	public int editName(MemberVo vo) throws Exception {
		if(vo.getName() == null || vo.getName()=="") {
			System.out.println("[MSN-S]이름 변경 실패 vo예외 발생");
			throw new Exception();
		}
		return dao.editName(vo, sst);
	}

	//프로필 소개 변경
	public int editIntro(MemberVo vo) throws Exception {
		if(vo.getIntro() == null || vo.getIntro()=="") {
			System.out.println("[MSI-S]소개 변경 실패 vo예외 발생");
			throw new Exception();
		}
		
		return dao.editIntro(sst, vo);
	}

	//프로필 웹사이트 변경
	public int editSiteUrl(MemberVo vo) throws Exception {
		if(vo.getSiteUrl() == null || vo.getSiteUrl() == "") {
			System.out.println("[MSS-S]웹사이트 변경 실패 vo예외 발생");
			throw new Exception();
		}
		
		return dao.editSiteUrl(sst, vo);
	}
	
}
