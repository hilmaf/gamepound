package com.gamepound.app.project.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.gamepound.app.member.vo.MemberVo;
import com.gamepound.app.project.ProjectAchievementRate;
import com.gamepound.app.project.dao.ProjectDaoHJY;
import com.gamepound.app.project.vo.ProjectVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceHJY {
	
	private final ProjectDaoHJY dao;
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
	public ProjectVo createMain(ProjectVo vo) {
		
		return dao.createMain(sst, vo);
	}
	
	// 작성률 계산
	public static double calculateCompletionRate(String[] row) {
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
	
}
