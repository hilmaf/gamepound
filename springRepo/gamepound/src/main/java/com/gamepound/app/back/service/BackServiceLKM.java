package com.gamepound.app.back.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.back.dao.BackDaoLKM;
import com.gamepound.app.back.vo.BackDetailVo;
import com.gamepound.app.back.vo.BackVo;
import com.gamepound.app.project.vo.ProjectBriefVo;
import com.gamepound.app.util.DataProcessingUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class BackServiceLKM {

	private final BackDaoLKM dao;
	private final SqlSessionTemplate sst;
	private final DataProcessingUtil util;
	private String url = "http://127.0.0.1:8889/gamepound/resources/images/projectImg/";
	
	// 후원하기(화면)
	public BackVo viewBackingPage(BackVo vo) {
		// 프로젝트 정보(DB)
		BackVo bvo = dao.viewBackingPage(sst, vo);
		
		// 달성률, 마감기한 d-, 결제예정일, 이미지 경로(서버)
		String achievementRate = util.achievementRate(bvo.getGoalAmount(), bvo.getCurrentAmount());
		String remainingPeriod = util.getRemainingPeriod(bvo.getEndDate(), "yyyy년 MM월 dd일");
		String paymentDueDate = util.calcPaymentDueDate(bvo.getEndDate(), "yyyy년 MM월 dd일");
		
		bvo.setAchievementRate(achievementRate);
		bvo.setRemainingPeriod(remainingPeriod);
		bvo.setPaymentDueDate(paymentDueDate);
		bvo.setProjectImg(url + bvo.getProjectImg());
		
		return bvo;
		
	}
	
	/**
	 * BACKER 테이블에 INSERT
	 * PAYMENT 테이블에 INSERT
	 * CARD 테이블에 INSERT 또는 KAKAOPAY 테이블에 INSERT
	 */
	// 후원하기
	public boolean back(BackDetailVo vo) throws Exception {
		// 결제수단 not null
		if(vo.getPaymentType() == null) {
			throw new Exception("결제수단 선택 필요");
		}

		// paymentType no setting
		if(vo.getPaymentType().equals("card")) {	
			vo = validateCardInfo(vo);
		} else {
			vo.setPaymentTypeNo("2");
		}
		
		System.out.println(vo);
		
		// rewardAmount 수정
		vo.setRewardAmount(util.removeCommas(vo.getRewardAmount()));
		// paymentAmount 세팅
		vo.setPaymentAmount(vo.getRewardAmount());		
		
		
		int result1 = dao.insertBack(sst, vo);
		int result2 = dao.insertPayment(sst, vo);
		int result3 = 0;
		if("1".equals(vo.getPaymentTypeNo())) {
			// 카드 정보 테이블 insert
			result3 = dao.insertCard(sst, vo);			
		} else {
			// 카카오페이 정보 테이블 insert
			result3 = dao.insertKakaopay(sst, vo);	
		}

		if(result1 == 1 && result2 == 1 && result3 == 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private BackDetailVo validateCardInfo(BackDetailVo vo) throws Exception {
		
		System.out.println(1);
		// 숫자only 정규표현식
		String numRegex = "\\d+";
		
		
		// 카드번호 유효성 체크 not null, max length 16, 숫자
		String[] cardNos = {vo.getCardNo1(), vo.getCardNo2(), vo.getCardNo3(), vo.getCardNo4()};
		String cardNo = util.compileInputs(cardNos);
		
		if(!cardNo.matches(numRegex) && (cardNo == null || cardNo.length() == 0 || cardNo.length() > 16)) {
			throw new Exception("카드번호 값 오류");
		}
	
		// 카드 유효기간 유효성 체크 not null, max length 4, 숫자
		String[] validThrus = {vo.getValidThru1(), vo.getValidThru2()};
		String validThru = util.compileInputs(validThrus);
		
		if(!validThru.matches(numRegex) && (validThru == null || validThru.length() == 0 || validThru.length() > 4)) {
			throw new Exception("카드 유효기간 값 오류");
		}
		
		// cardPwd 유효성 체크: not null, max length 2, 숫자
		String cardPwd = vo.getCardPwd();
		if(!cardPwd.matches(numRegex) && (cardPwd == null || cardPwd.length() == 0 || cardPwd.length() > 2)) {
			throw new Exception("카드 비밀번호 값 오류");
		}
		
		// birthDate 유효성 체크: not null, max length 6, 숫자
		String birthDate = vo.getBirthDate();
		if(!birthDate.matches(numRegex) && (birthDate == null || validThru.length() == 0 || validThru.length() > 4)) {
			throw new Exception("생년월일 오류");
		}
				
		vo.setPaymentTypeNo("1");
		vo.setCardNo(cardNo);
		vo.setValidThru(validThru);
		
		return vo;
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
		
		
		bvo.setProjectImg(url + bvo.getProjectImg());
		
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
