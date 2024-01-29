package com.gamepound.app.project.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;
import com.gamepound.app.settlement.vo.SettlementVo;


@Transactional // 테스트만 수행하고 DB 롤백
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*.xml")
class ProjectCreateDaoTest {

	private ProjectDaoHJY dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
	@BeforeEach
    void setUp() {
        // 테스트 전에 초기화 작업
		dao = new ProjectDaoHJY();
    }

	@DisplayName("작성중 프로젝트 조회")
	@Test
	void getCurrentProject() {
		
		// given
		MemberVo loginMember = new MemberVo();
		loginMember.setNo("1");
		
		// when
		List<ProjectVo> vo = dao.getCurrentProject(sst, loginMember);
		
		// then
		assertTrue(vo != null);
	}
	
	@DisplayName("프로젝트 올리기 (카테고리 저장 및 insert)")
	@Test
	void newProject() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setCategoryNo("1");
		projectVo.setMemberNo("1");
		projectVo.setTitle("제목");
		projectVo.setImageUrl("imageUrl.png");
		
		// when
		ProjectVo resultVo = null;
		try {
			resultVo = dao.newProject(sst, projectVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// then
		assertTrue(resultVo != null);
		
	}
	
	
	@DisplayName("프로젝트 내용 조회 (메인)")
	@Test
	void createMain() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("2");
		
		// when
		ProjectVo resultVo = dao.createMain(sst, projectVo);
		
		// then
		assertTrue(resultVo != null);
	}
	
	@DisplayName("프로젝트 작성조회 : 펀딩계획")
	@Test
	void getPlan() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("2");
		
		// when
		ProjectVo resultVo = dao.getPlan(sst, projectVo);
		
		// then
		assertTrue(resultVo != null);
		
	}
	
	@DisplayName("프로젝트 작성조회 : 프로젝트 계획")
	@Test
	void getDateplan() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("2");
		
		// when
		ProjectVo resultVo = dao.getDateplan(sst, projectVo);
		
		// then
		assertTrue(resultVo != null);
		
	}
	
	
	@DisplayName("프로젝트 작성저장 : 기본정보")
	@Test
	void saveBasic() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("2");
		projectVo.setCategoryNo("3");
		projectVo.setTitle("수정타이틀");
		projectVo.setImageUrl("editImageUrl.jpg");
		
		// when
		int result = dao.saveBasic(sst, projectVo);
		
		// then
		assertTrue(result == 1);
		
	}
	@DisplayName("프로젝트 작성저장 : 펀딩계획")
	@Test
	void savePlan() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("2");
		projectVo.setGoalAmount("1500000");
		projectVo.setStartDate("2024-01-29");
		projectVo.setEndDate("2024-02-29");
		
		// when
		int result = dao.savePlan(sst, projectVo);
		
		// then
		assertTrue(result == 1);
		
	}

	@DisplayName("프로젝트 작성 : 선물구성")
	@Test
	void createReword() {
		
		// given
		RewardVo rewardVo = new RewardVo();
		rewardVo.setProjectNo("2");
		rewardVo.setAmount("3000");
		rewardVo.setName("선물이름");
		
		// when
		int result = dao.createReword(sst, rewardVo);
		
		// then
		assertTrue(result == 1);
		
	}
	@DisplayName("프로젝트 작성저장 : 선물구성")
	@Test
	void saveReword() {
		
		// given
		RewardVo rewardVo = new RewardVo();
		rewardVo.setProjectNo("2");
		rewardVo.setNo("2");
		rewardVo.setAmount("3000");
		rewardVo.setName("선물이름");
		
		// when
		int result = dao.saveReword(sst, rewardVo);
		
		// then
		assertTrue(result == 1);
		
	}
	@DisplayName("프로젝트 선물삭제 : 선물구성")
	@Test // 프로젝트 진행중일시 삭제 불가
	void deleteReword() {
		
		// given
		RewardVo rewardVo = new RewardVo();
		rewardVo.setNo("50");
		
		// when
		int result = dao.deleteReword(sst, rewardVo);
		
		// then
		assertTrue(result == 1);
		
	}
	
	@DisplayName("프로젝트 작성저장 : 프로젝트 계획")
	@Test
	void saveDateplan() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("1");
		projectVo.setTxtDescription("작성내용");
		projectVo.setTxtBudget("작성내용");
		projectVo.setTxtSchedule("작성내용");
		projectVo.setTxtTeam("작성내용");
		projectVo.setTxtItem("작성내용");
		
		// when
		int result = dao.saveDateplan(sst, projectVo);
		
		// then
		assertTrue(result == 1);
		
	}
	@DisplayName("프로젝트 작성저장 : 창작자 정보")
	@Test
	void saveUserinfo() {
		
		// given
		SettlementVo settlementVo = new SettlementVo();
		settlementVo.setProjectNo("21");
		settlementVo.setBankName("기업은행");
		settlementVo.setName("홍길동");
		settlementVo.setAccountNum("123412341234");
		
		// when
		int result = dao.saveUserinfo(sst, settlementVo);
		
		// then
		assertTrue(result == 1);
		
		
	}
	@DisplayName("프로젝트 승인 요청")
	@Test
	void approvalProject() {
		
		// given
		ProjectVo projectVo = new ProjectVo();
		projectVo.setNo("20");
		
		// when
		int result = dao.approvalProject(sst, projectVo);
		
		// then
		assertTrue(result == 1);
		
	}

}
