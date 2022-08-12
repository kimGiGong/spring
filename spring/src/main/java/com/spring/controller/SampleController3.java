package com.spring.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample3/*")
@Log4j
public class SampleController3 {

	
	//	리턴타입 String : jsp 페이지 경로 리턴
	@RequestMapping("ex01")
	public String ex01() {
		
		log.info("ex01!!");
		
		return "sample/test";
	}
	
	
	
	
	//	리턴 타입 void : url 경로 = jsp 페이지 경로
	@RequestMapping("ex02")
	public void ex02() {
		
		log.info("ex02!!");
		
	}
	
	
	
	//	리턴타입 VO,DTO
	@RequestMapping("ex03")
	@ResponseBody
	public SampleDTO ex03() {
		log.info("ex03!!!");
		SampleDTO dto = new SampleDTO();
		dto.setId("hello");
		dto.setPw("1234");
		
		return dto;
	}
	
	
	
	
	
	//	리턴타입 ResponseEntity
	@RequestMapping("ex04")
	public ResponseEntity<String> ex04(){
		log.info("ex04");
		
		//	보낼 데이터
//		String msg = "helloooooooooooooooooooo";
				
		// { "name" : "피카츄" }
		String msg = "{\"name\" : \"피카츄\"}";
		
		
		
		
		//	헤더 정보
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/json;charset=UTF-8");		//text/plain 일반 문자열
		
		ResponseEntity<String> entity = new ResponseEntity<String>(msg, headers , HttpStatus.OK);
		return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
