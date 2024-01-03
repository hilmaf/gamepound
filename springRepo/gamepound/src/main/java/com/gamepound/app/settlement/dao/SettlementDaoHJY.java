package com.gamepound.app.settlement.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.project.vo.ProjectVo;
import com.gamepound.app.settlement.vo.SettlementVo;

@Repository
public class SettlementDaoHJY {

	// 프로젝트넘버로 정산정보 조회
	public SettlementVo getSettlementByNo(SqlSessionTemplate sst, ProjectVo vo) {
		return sst.selectOne("SettlementCreateMapper.getSettlementByNo", vo);
	}
	
}
