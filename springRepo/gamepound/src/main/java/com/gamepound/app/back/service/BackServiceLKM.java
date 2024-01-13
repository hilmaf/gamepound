package com.gamepound.app.back.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.BackDaoLKM;
import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;
import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.ProjectDataTransformation;
import com.gamepound.app.project.ProjectRemainingPeriod;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BackServiceLKM {

	private final BackDaoLKM dao;
	private final SqlSessionTemplate sst;
	private final DataProcessingUtil util;
	
	// 후원하기(화면) - 프로젝트 정보 가져오기
	public BackVo viewBackingPage(BackVo vo) {
		BackVo bvo = dao.viewBackingPage(sst, vo);
		
		// 달성률, 마감기한 d- setting
		System.out.println(bvo.getEndDate());
		String achievementRate = util.achievementRate(bvo.getGoalAmount(), bvo.getCurrentAmount());
		String remainingPeriod = util.getRemainingPeriod(bvo.getEndDate(), "yyyy년 MM월 dd일");
		String paymentDueDate = util.calcPaymentDueDate(bvo.getEndDate(), "yyyy년 MM월 dd일");
		
		bvo.setAchievementRate(achievementRate);
		bvo.setRemainingPeriod(remainingPeriod);
		bvo.setPaymentDueDate(paymentDueDate);
		
		return bvo;
		
	}
	
	// 후원하기
	public boolean back(BackDetailVo vo) throws Exception {
		// NullCheck
		if(vo.getPaymentType() == null) {
			throw new Exception("결제수단 선택 필요");
		}
		
		// paymentType no setting
		if(vo.getPaymentType() == "card") {
			vo.setPaymentTypeNo("1");
		} else {
			vo.setPaymentTypeNo("2");
		}
		
		// 후원정보에 insert
		int result1 = dao.insertBack(sst, vo);
		
		// 결제정보에 insert
		int result2 = dao.insertPayment(sst, vo);
		
		if(result1 != 1 && result2 != 1) {
			throw new Exception("후원 등록에 실패함");
		}

		boolean backed = true;
		
		return backed;
	}

	// 후원완료(n번째 후원자)
	public String cntBacker(String projectNo) {		
		return dao.cntBacker(sst, projectNo);
	}

	// 후원취소
	public boolean cancel(String backNo) throws Exception {
		
		// 후원정보 update
		int result1 = dao.updateRetractYn(sst, backNo);
		// 결제정보 delete
		int result2 = dao.deletePayment(sst, backNo);
		
		if(result1 != 1 && result2 != 1) {
			throw new Exception("후원 취소에 실패함");
		}
		
		boolean canceled = true;
		
		return canceled;
	}
	
	// 후원 상세 조회
	public BackDetailVo detail(String backNo) {
	
		BackDetailVo bvo = dao.detail(sst, backNo);
		
		String achievementRate = util.achievementRate(bvo.getGoalAmount(), bvo.getCurrentAmount());
		bvo.setAchievementRate(achievementRate);
		
		return bvo;
	}

	// 후원 내용 변경 - 선물 변경
	public int changeReward(BackVo vo) {
		return dao.changeReward(sst, vo);
	}

	public int changePaymentType(BackVo vo) {
		return dao.changePayment(sst, vo);
	}

}
