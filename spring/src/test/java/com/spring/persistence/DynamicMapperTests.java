package com.spring.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.SampleDTO;
import com.spring.mapper.DynamicMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml" ,
		"classpath:mybatis/mybatis-config.xml"})
@Log4j
public class DynamicMapperTests {
	
	@Autowired	//	각 테스트 메서드가 실행되기 이전에 먼저 실행되는 메서드로 지정
	private DynamicMapper mapper;
	
	private SampleDTO dto;	//	픽스쳐
	
	@Before	
	public void createFixture() {
		dto = new SampleDTO();
	//	dto.setId("spring05");	//	테이블에 존재하는 id
	//	dto.setPw("0000");
	//	dto.setAge(0);
	}
	/*
	@Test
	public void testSelectIf() {
		log.info("----------------------------------------------------------");
		log.info("---------------------- selectIf --------------------------");
		log.info("----------------------------------------------------------");
		log.info("selectIf : "+mapper.selectIf("java14"));
	}
	
	
	
	@Test
	public void testSelectIf2() {
		log.info("----------------------------------------------------------");
		log.info("---------------------- selectIf2 --------------------------");
		log.info("----------------------------------------------------------");
		log.info("selectIf2 : "+mapper.selectIf2(dto));
	}
	

	
	@Test
	public void testSelectTrim() {
		log.info("----------------------------------------------------------");
		log.info("---------------------- selectTrim --------------------------");
		log.info("----------------------------------------------------------");
		log.info("selectIf2 : "+mapper.selectTrim(dto));
	}
	

	
	@Test
	public void testUpdate() {
		log.info("----------------------------------------------------------");
		log.info("---------------------- testUpdate --------------------------");
		log.info("----------------------------------------------------------");
		log.info("testUpdate : "+mapper.updateTest(dto));
	}
	
	
	
	
	
	@Test
	public void testSelectIn() {
		List<String> list = new ArrayList<String>();
		list.add("java14");
		list.add("test");
		list.add("java10");
		list.add("hello");
		list.add("spring01");
		
		int result = mapper.selectIn(list);
		log.info("result list : "+ result);
	}
	
	
	
	
	
	@Test
	public void testSelectKey() {
		log.info("*-*-*-*-*-* dto.getAge() *-*-*-*-*--* "+ dto.getAge());
		log.info(mapper.updateKey(dto));
		log.info("*-*-*-*-*-* dto.getAge() *-*-*-*-*--* "+ dto.getAge());
	}
	
	
	
	@Test
	public void testInsertKey() {
		log.info("*-*-*-*-*-* testInsertKey() *-*-*-*-*--* "+ dto.getAge());
		int result = mapper.insertKey(dto);
		assertThat(result, is(1));
		log.info("*-*-*-*-*-* testInsertKey() *-*-*-*-*--* "+ dto.getAge());
	}
	
	*/
	
	
	/*
	JUnit 테스트 검증 메서드
	assertThat(검증할 값, 매처) : 값이 매처에서 요구하는것과 일치하는지
	 			매처 : is() 메서드 사용
	assertEquals(a,b): 객체 a와 b가 일치하는지 (값이 같은지) 확인
	assertTrue(a) : a가 참인가 확인
	assertSame(a,b) : a와 b가 동일한 객체인지 확인 (==)
	assertNotNull(a) : 객체 a가 null이 아님을 확인
	*/
	
	
	
	
	
	@Test
	public void testAssertCount() {
		assertThat(mapper.selectTrim(dto),is(12));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
