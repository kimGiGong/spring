package com.board.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.b;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	//	CRUD
	
	@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getList();
		for(BoardVO vo : list) {
			log.info(vo);
		}
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 제목3");
		board.setContent("테스트 내용3");
		board.setWriter("user3");
		
		//	mapper.insert(board);
		log.info("bno insert 전" + board.getBno());
		//mapper.insertSelectKey(board);
		assertThat(mapper.insertSelectKey(board),is(7));
		log.info("bno insert 후" + board.getBno());
	}
	
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(7L);
		log.info("=======================================================");
		log.info(board);
		log.info("=======================================================");
	}
	
	
	@Test
	public void testDelete() {
		assertThat(mapper.delete(8L),is(1));
	}
	
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정젬목");
		board.setContent("수정내용");
		board.setWriter("수정한놈");
		assertThat(mapper.update(board), is(1));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
