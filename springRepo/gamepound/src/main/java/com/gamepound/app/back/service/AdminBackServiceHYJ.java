package com.gamepound.app.back.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.AdminBackDaoHYJ;
import com.gamepound.app.back.vo.AdminBackVo;
import com.gamepound.app.member.dao.MemberDaoHYJ;
import com.gamepound.app.page.vo.PageVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminBackServiceHYJ {
	private final AdminBackDaoHYJ dao;
	private final SqlSessionTemplate sst;
	
	//목록
	public Map<String, Object> backList(AdminBackVo vo, String pageNum) {
		Map<String, Object>map = new HashMap<String, Object>();

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
		List<AdminBackVo>voList = dao.backList(sst);
		map.put("voList", voList);
		
		return map; 
	}

	//상세
	public AdminBackVo backDetail(AdminBackVo vo) {
		return dao.backDetail(sst, vo);
	}
}
