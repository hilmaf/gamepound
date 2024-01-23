package com.gamepound.app.payment.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.gamepound.app.category.vo.CategoryVo;
import com.gamepound.app.page.vo.PageVo;

@Repository
public class AdminPaymentDaoHJY {

	// 전체 조회 갯수
	public int countPaymentList(SqlSessionTemplate sst) {
		return sst.selectOne("AdminPaymentMapper.countPaymentList");
	}

	// 전체 조회
	public List<CategoryVo> getPaymentList(SqlSessionTemplate sst, PageVo pvo) {
		int offset = (pvo.getCurrentPage() - 1) * pvo.getBoardLimit(); // 몇개의 게시물 건너뛸건지
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset, limit);
		return sst.selectList("AdminPaymentMapper.getPaymentList", null, rb);
	}

}
