package com.board.persistence;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;

public interface BoardMapper {
	
	//	CRUD
	//	전체 레코드 검색
	public List<BoardVO> getList();	//	페이징처리 안되는 버전
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//	글 저장		C: Create
	public void insert(BoardVO board);
	public int insertSelectKey(BoardVO board);
	
	// 그 한개 가져오기 R : Read
	public BoardVO read(Long bno);
	
	
	// 글 삭제  D : Delete 
	public int delete(Long bno);
	
	
	//	글 수정 : U : Update
	public int update(BoardVO board);	
	
	
	//	글 갯수 조회하기
	public int getTotalCount(Criteria cri);
	
	
}
