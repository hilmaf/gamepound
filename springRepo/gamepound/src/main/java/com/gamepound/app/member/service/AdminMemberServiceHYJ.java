package com.gamepound.app.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.dao.AdminMemberDaoHYJ;
import com.gamepound.app.member.dao.MemberDaoHYJ;
import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.page.vo.PageVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminMemberServiceHYJ {
	private final AdminMemberDaoHYJ dao;
	private final SqlSessionTemplate sst;
	
	//목록
	public Map<String, Object> memberList(MemberVo vo, String pageNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		//조건에 맞는 게시글 수
		int listCount = dao.listCnt(sst, vo);
		
		//페이징
		if(pageNum == null) {
			pageNum = "1";
		}
		int cutterntPage = Integer.parseInt(pageNum);
		int pageLimit = 5;
		int boardLimit = 10;
		PageVo pvo = new PageVo(listCount, cutterntPage, pageLimit, boardLimit);
		map.put("pvo", pvo);
		
		//조건에 맞는 게시글들
		List<MemberVo> voList = dao.memberList(sst, vo, pvo);
		for (MemberVo memberVo : voList) {
			if(memberVo.getUpdateDate() == null) {
				memberVo.setUpdateDate("-");
			}
		}
		map.put("voList", voList);
		
		return map;
	}

	//상세
	public MemberVo memberDetail(MemberVo vo) {
		return dao.memberDetail(sst, vo);
	}

	//수정
	public int memberEdit(MemberVo vo) {
		return dao.memberEdit(sst, vo);
	}

}
