package com.board.service;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class TestServiceImpl implements TestService {

	@Override	//	핵심 메서드 
	public void helloAOP(Integer a, Integer b) {
	//	log.info(0/0);
		log.info(" *************** Hello AOP Service method ============");
		
	}

}
