package com.gamepound.app.reward.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.reward.vo.RewardVo;

@Repository
public class RewardDaoHJY {
	
	/**
	 * 현지연 reward dao
	 * */

	// 프로젝트넘버로 선물 조회
	public List<RewardVo> getRewardListByNo(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectList("rewardCreateMapper.getRewardListByNo", vo);
	}

}
