package com.gamepound.app.page.vo;

import lombok.Data;

@Data
public class PageVo {

	private int listCount;		// 총 게시글 개수
	private int currentPage;	// 현재 페이지
	private int pageLimit;		// 페이지 영역 페이지 개수
	private int boardLimit;		// 한 페이지에 보여줄 게시글 개수
	// 그냥 개발자가 정하는 값
	
	
	private int maxPage;		// 가장 마지막 페이지
	private int startPage;		// 페이징 영역 시작값
	private int endPage;		// 페이징 영역 마지막값
	// 위 단락에 있는 값 가지고 연산해서 나올 값
	
	private int startRow;		// 조회할 첫번째 행 번호(ROWNUM)
	private int lastRow;		// 조회할 마지막 행 번호(ROWNUM)
	
	// 생성자
	// 기본 생성자 없는 이유: 매개변수 4개의 값은 반드시 채워져있어야 함
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int) Math.ceil((double)listCount / boardLimit);
		this.startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		this.endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		this.startRow = (currentPage - 1) * boardLimit + 1;
		this.lastRow = startRow + boardLimit - 1;
	}
}
