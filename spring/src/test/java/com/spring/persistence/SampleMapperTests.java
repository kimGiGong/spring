package com.spring.persistence;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.SampleDTO;
import com.spring.mapper.SampleMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml" ,
		"classpath:mybatis/mybatis-config.xml"})
@Log4j
public class SampleMapperTests {
	
	@Autowired				//	객체 주입받기
	private SampleMapper sampleMapper;
	
	
	
	
	
	
	@Test				//	test 메서드 실행
	public void testGetCount() {		
		log.info("********************************* testGetCount *****************");
		log.info(sampleMapper.getCount());
	}
	
	@Test
	public void testGetMaxAge() {		
		log.info("********************************* testGetMaxAge *****************");
		log.info("max age : "+sampleMapper.getMaxAge());
	}

	@Test
	public void testGetAll() {
		log.info("********************************* testGetAll *****************");
		//	log.info("getAllRecord List : "+sampleMapper.getAllRecord());
		List<SampleDTO> list = sampleMapper.getAllRecord();
		for(int i =0 ; i<list.size();i++) {
			SampleDTO dto = list.get(i);
			log.info(dto.getId() +"/"+ dto.getPw() +"/"+ dto.getAge() +"/"+ dto.getReg() );
		}
		
	}
	
	
	
	@Test
	public void testGetOneRecord() {
		log.info("********************************* testGetOneRecord *****************");
		String id = "java10";
		log.info("result : "+sampleMapper.getOneRecord(id));
	}
	
	
	@Test
	public void testGetRegById() {
		log.info("********************************* testGetRegById *****************");
		String id = "java10";
		log.info("testGetRegById : "+sampleMapper.getRegById(id));
	}
	
	
	
	
	@Test
	public void testInsert() {
		log.info("********************************* testInsert *****************");
		SampleDTO dto = new SampleDTO();
		dto.setId("spring01");
		dto.setAge(10);
		dto.setPw("1234");
		sampleMapper.insertRecord(dto);
	}
	
	
	
	@Test
	public void testUpdate() {
		log.info("********************************* testUpdate *****************");
		/*
		SampleDTO dto = new SampleDTO();
		dto.setId("spring01");
		dto.setAge(20);
		dto.setPw("2468");
		*/
	//	log.info("update result : "+sampleMapper.updateRecord("spring01","5555",123));
		HashMap map = new HashMap();
		map.put("id","spring01");
		map.put("pw","123456");
		map.put("age",1212);
		log.info("update result : "+sampleMapper.updateRecord2(map));
	}
	
	
		
	
	
	
	
	
	@Test
	public void testDelete() {
		log.info("********************************* testDelete *****************");
		log.info("testDelete result : "+sampleMapper.deleteRecord("jdbk"));
	}
	
	
	
	
	
	
	
	
	
	
}

