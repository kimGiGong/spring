package com.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info(timeMapper);
		log.info(timeMapper.getClass().getName());
		//	우리가 만든 SQL어노테이션 붙은 추상 메서드 호출! 리턴 결과 출력
		log.info(timeMapper.getTime());
	}
	
		
	
	@Test
	public void testGetTime2() {
		log.info("**************  getTime2  ************************");
		log.info(timeMapper.getTime2());
	}
	
	
	
	
	
	
	
	
}
