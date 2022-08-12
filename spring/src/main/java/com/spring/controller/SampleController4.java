package com.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleTV;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample4/*")
@Log4j
public class SampleController4 {

	//	기존 방식으로 객체 생성
	
	
	
	/*	스프링에서는 DI 라는 의존성 주입 기술을 통해 의존하는 객체를 전달받아 사용함.	
	 	객체생성은 xml 파일에 <bean>으로 등록하여, 스프링의 BeanFactory가 생성/관리 하도록 지정한다
	 	해당 스프링빈(객체)이 필요한 곳에서 주입받아(빌려오기) 사용가능하록 되어있다.
	 	@Autowired : 의존성 자동 주입
	 		바인딩 기준
	 			1. 변수의 타입과 같은 빈이 있으면 주입 (변수이름과 bean id값이 달라도 상관없음 (빈이 하나라면))
	 			2. 같은 타입의 빈이 여러개 있다면, bean의 id속성값과 변수명이 동일한것을 주입해줌 
	*/
	
	@Autowired
	private Date day = null;
	@Autowired
	private Date day2 = null;
	
	
	
//	@Setter(onMethod_=@Autowired)
	@Autowired
	private SampleTV tv = null;
	
	
	@RequestMapping("test")
	public String test(Model model) {
		/*
	//	 day = new Date();			@Autowired 가 대신한다
		log.info("test 요청!!");
		log.info(day);
		log.info(day2);
		
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol("blue");
		*/
		log.info(tv.isPower());		//boolean 타입은 isPower
		log.info(tv.getCh());
		log.info(tv.getCol());
		log.info(tv.getReg());
		
		model.addAttribute("TV",tv);
		
		return "sample/test";
	}
	
	
	
	
	
	
	
	@GetMapping("login")
	public String form() {
		log.info("form 요청~");
		
		
		return "sample/form";
	}
	@PostMapping("login")
	public String login(SampleDTO dto) {
		log.info("login POST 요청!!");
		log.info(dto.getId());
		log.info(dto.getPw());
		
		
//		return "sample/test"; 	//	login POST 요청건의 jsp 뷰만 바꾸기
		return "redirect:/sample4/test";	//	자바 리턴값으로 /sample4/test 요청 -> controller
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
