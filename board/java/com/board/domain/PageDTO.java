package com.board.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {	//	페이지 번호등 페이징 처리시 필요한 정보 담는 클래스
	
	private int startPage;
	private int endPage;
	private boolean prev, next; 	//	페이지 번호 앞으로가기 뒤로가기 활성화 여부
	
	private int total;	//	전체 글의 갯수
	private Criteria cri;	//	페이지 번호 pageNum, 페이지당 보여줄 글의 갯수 listQty
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0)) * 10;
		this.startPage = this.endPage - 9;
		int realEnd = (int)(Math.ceil((total* 1.0)/cri.getListQty()));
		if(realEnd < this.endPage) {		//	전체페이지 수보다 endPage가 크면 
			this.endPage = realEnd;		//	마지막 페이지번호를 전체페이지로 변경
		}
	
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
