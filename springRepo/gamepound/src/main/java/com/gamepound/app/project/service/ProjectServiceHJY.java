package com.gamepound.app.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.dao.ProjectDaoHJY;
import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.dao.RewardDaoHJY;
import com.gamepound.app.reward.vo.RewardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHJY {
	
	/**
	 * 현지연 프로젝트 서비스
	 * */

	private final ProjectDaoHJY dao;
	private final RewardDaoHJY rewardDao;
	private final SqlSessionTemplate sst;

	// 작성중 프로젝트 조회
	public List<ProjectVo> getCurrentProject(MemberVo loginMember) {
		return dao.getCurrentProject(sst, loginMember);
	}

	// 프로젝트 올리기 (카테고리 저장 및 insert)
	public int newProject(ProjectVo vo) throws Exception {
		
		// 카테고리 null이거나 ''빈값 검증
		if(vo.getCategoryNo() == null && vo.getCategoryNo().isEmpty()) {
			throw new Exception("카테고리를 결정하지 않았습니다.");
		}
		
		return dao.newProject(sst, vo);
	}

	// 프로젝트 내용 조회 (메인)
	public Map<String, Object> createMain(ProjectVo vo) {
		
		ProjectVo mainVo = dao.createMain(sst, vo);
		
		// 퍼센트 계산 + 작성률 계산 후 리턴
		return calculatePercent(mainVo);
	}
	
	// 퍼센트 계산
	public Map<String, Object> calculatePercent(ProjectVo mainVo){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("mainVo", mainVo);
		
		// 기본정보 작성률
		String[] basic = {mainVo.getMainCategory(),mainVo.getSubCategory(), mainVo.getTitle(), mainVo.getImageUrl()};
		double basicPercent = calculateCompletionRate(basic);
		map.put("basicPercent", basicPercent);
		
		// 펀딩계획 작성률
		String[] plan = {mainVo.getGoalAmount(), mainVo.getStartDate(), mainVo.getEndDate()};
		double planPercent = calculateCompletionRate(plan);
		map.put("planPercent", planPercent);
		
		// 선물 작성률 : 선물 테이블에 행이있으면 100% 아니면 0%
		List<RewardVo> rewardVo = rewardDao.getRewardListByNo(sst, mainVo);
		double rewardPercent = (rewardVo != null && !rewardVo.isEmpty()) ? 100.0 : 0.0;
	    map.put("rewardPercent", rewardPercent);
		
		// 프로젝트계획 작성률
		String[] dateplan = {mainVo.getTxtDescription(), mainVo.getTxtBudget(), mainVo.getTxtSchedule(), mainVo.getTxtTeam(), mainVo.getTxtItem()};
		double dateplanPercent = calculateCompletionRate(dateplan);
		map.put("dateplanPercent", dateplanPercent);
		
		// 창작자 정보 작성률 TODO-현지연 ProjectDetailVo 만들어지면 수정하기
		String[] userinfo = {};
		double userinfoPercent = calculateCompletionRate(userinfo);
		map.put("userinfoPercent", userinfoPercent);
		
		return map;
	}
	
	// 작성률 계산
	public double calculateCompletionRate(String[] row) {
        if (row == null || row.length == 0) {
            // 배열이나 리스트가 null이거나 비어있으면 작업이 없음
            return 0.0;
        }

        int totalTasks = row.length;
        int completedTasks = 0;

        for (String columnValue : row) {
            if (columnValue != null) {
                completedTasks++;
            }
        }

        // 작성률 계산
        double completionRate = ((double) completedTasks / totalTasks) * 100;
        return completionRate;
    }

	// 프로젝트 작성조회 : 기본정보
	public ProjectVo getBasic(ProjectVo vo) {
		return dao.getBasic(sst, vo);
	}

	// 프로젝트 작성조회 : 펀딩계획
	public ProjectVo getPlan(ProjectVo vo) {
		return dao.getPlan(sst, vo);
	}
	
}
