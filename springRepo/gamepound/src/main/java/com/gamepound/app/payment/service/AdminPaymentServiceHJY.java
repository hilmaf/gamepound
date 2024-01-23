package com.gamepound.app.payment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.page.vo.PageVo;
import com.gamepound.app.payment.dao.AdminPaymentDaoHJY;
import com.gamepound.app.payment.vo.PaymentVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminPaymentServiceHJY {
	
	private final AdminPaymentDaoHJY dao;
	private final SqlSessionTemplate sst;

	// 전체 조회하기
	public Map<String, Object> getPaymentList(String pageNum) {
		
		int listCount = dao.countPaymentList(sst);       //전체 게시글 갯수
        log.info("전체 게시글 개수 : {}", listCount);
        String currentPage_= pageNum;
        if(currentPage_ == null) {
        	currentPage_ = "1";
        }
        int currentPage = Integer.parseInt(currentPage_);   //현재 페이지
        int pageLimit = 5; 									// 페이지 영역 페이지 개수
        int boardLimit = 10; 								// 한 페이지에 보여줄 게시글 개수
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);
        log.info("pvo : {}", pvo);
        List<CategoryVo> listVo = dao.getPaymentList(sst, pvo);
		
        // 리스트와 pvo 같이 전달
        Map<String, Object> map = new HashMap<>();
        map.put("listVo", listVo);
        map.put("pvo", pvo);
		
		return map;
	}
	
}
