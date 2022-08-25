package com.board.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Criteria {	//	게시판에 사용시 부수적으로 필요한 데이터들 묶음
	
	
	private int pageNum;	//	페이지 번호
	private int listQty;	//	한페이지에 보여줄 게시물 갯수
	
	public Criteria() {
		this(1, 10);	//	페이지 번호 1 이고 10개씩 보여주겠다.
	}
	public Criteria(int pageNum, int listQty) {
		this.pageNum = pageNum;
		this.listQty = listQty;
	}
	
	
	
	//	URL 링크 붙히는 쿼리 스트링 자동 생성해주는 메서드
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum",this.pageNum)
				.queryParam("listQty", this.listQty);
		
		return builder.toUriString();	//	?pageNum=1&listQty=10
	}
	
	
	
	
	
	
	
	
	
	
}
