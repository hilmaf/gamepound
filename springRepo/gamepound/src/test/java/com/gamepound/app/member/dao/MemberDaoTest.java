package com.gamepound.app.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.gamepound.app.member.vo.MemberVo;


@Transactional // 테스트만 수행하고 DB 롤백
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*.xml")
class MemberDaoTest {
	
	private MemberDaoHJY dao;

	@Autowired
	private SqlSessionTemplate sst;
	
	
	@BeforeEach
    void setUp() {
        // 테스트 전에 초기화 작업
		dao = new MemberDaoHJY();
    }
	
	@DisplayName("회원가입 성공 검사")
	@Test
	void joinMember() {
		
		// given
		MemberVo newMember = new MemberVo();
		newMember.setNo("100");
		newMember.setName("홍길동");
		newMember.setEmail("ghdrlfehd@naver.com");
		newMember.setPwd("1234");
		newMember.setConfirmPwd("1234");
		
		// when
		int result = dao.join(sst, newMember);
		
		// then
		assertTrue(result == 1); // 회원가입이 성공했을 경우를 확인
	}

	@DisplayName("로그인 검사")
	@Test
	void loginMember() {
		
		// given
		MemberVo newMember = new MemberVo();
		newMember.setEmail("clsrnclsrn1111@naver.com");
		newMember.setPwd("1234");
		
		// when
		MemberVo loginMember = dao.login(sst, newMember);
		
		// then
		assertEquals(newMember.getEmail(), loginMember.getEmail());
		
	}

	@DisplayName("회원탈퇴 검사")
	@Test
	void quitMember() {
		// given
		MemberVo loginMember = new MemberVo();
		loginMember.setNo("1");
		loginMember.setPwd("$2a$10$EAUCN4zA7ZBj6CZwAoCIbeSmQ9ujAXECLR.cx0T1CydXJ7cU.7JgG");
		
		// when
		int result = dao.quit(sst, loginMember);
		
		// then
		assertTrue(result == 1);
	}

	@DisplayName("이메일 중복 검사")
	@Test
	void emailUnique() {
		
		// given
		MemberVo loginMemberTrue = new MemberVo();
		MemberVo loginMemberFalse = new MemberVo();
		loginMemberTrue.setEmail("clsrnclsrn1111@naver.com");
		loginMemberFalse.setEmail("clsrnclsrn1@naver.com");
		
		// when
		int resultTrue = dao.isEmailUnique(sst, loginMemberTrue);
		int resultFalse = dao.isEmailUnique(sst, loginMemberFalse);
		
		// then
		assertTrue(resultTrue > 0);
		assertFalse(resultFalse > 0);
	}

	@DisplayName("비밀번호 재설정 검사")
	@Test
	void resetPassword() {
		
		// given
		MemberVo loginMember = new MemberVo();
		loginMember.setEmail("clsrnclsrn1111@naver.com");
		loginMember.setPwd("4321");
		
		// when
		int result = dao.resetPassword(sst, loginMember);
		
		// then
		assertTrue(result == 1);
		
	}

}
