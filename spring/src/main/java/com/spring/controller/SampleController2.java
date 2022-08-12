package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.SampleDTO;
import com.spring.dto.SampleDTOList;
import com.spring.dto.SampleTV;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample2/*")
@Log4j
public class SampleController2 {

	// 8080/sample2/hello?id=java&pw=1234
	@RequestMapping("hello")
	public String hello(SampleDTO dto, String id , int pw) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());
		System.out.println("id : "+id);
		System.out.println("pw : "+(pw+100000));
		
		return "sample/hello";
	}

	
	
	//	...8080/sample2/hello2?name=AAA&age=10
	@RequestMapping("hello2")
	public String hello2(@RequestParam(value="name",defaultValue = "hello") String name2 , @RequestParam("age") int age2) {
		
		log.info("hello2 매핑메세지");
		log.info("name : "+name2);
		log.info("age : "+age2);
		
		return "sample/hello";
	}
	
	
	//	동일한 이름의 파라미터가 여러개 전달되는 경우 ArrayList, 배열 사용가능 
	// 리스트 파라미터
	//	.../sample2/hello3?names=AAA&names=BBB&names=CCC
	@RequestMapping("hello3")
	public String hello3(@RequestParam ArrayList<String> names) {
		log.info(names);

		
		
		
		return "sample/hello";
	}
	
	
	
	//	배열
	@RequestMapping("hello4")
	public String hello4(String[] names) {
		for(String s : names) {
			log.info(s);
		}
		
		
		return "sample/hello";
	}
	
	
	//	객체 리스트
	@RequestMapping("hello5")
	public String hello5(SampleDTOList list) {
		// .../sample2/hello5?list[0].id=AAA&list[1].id=BBB
		// .../sample2/hello5?list%5B0%5D.id=AAA&list%5B1%5D.id=BBB
		log.info(list);
		
		
		return "sample/hello"; 
	}
	
	@RequestMapping("form")
	public String form() {
		
		return "sample/form";
	}
	
	
	@RequestMapping("pro")
	public String pro(String id, String pw,SampleDTO dto, Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		log.info(id);
		log.info(pw);
		log.info(dto.getId());
		log.info(dto.getPw());
		
		//	view에 데이터 전달
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		request.setAttribute("reqId", id);
		request.setAttribute("reqPw", pw);
		
		return "sample/pro";
	}
	
	
	//	ModelAndView
	@RequestMapping("pro2")
	public ModelAndView pro2(String id , String pw , SampleDTO dto) {
		//	객체 생성
		ModelAndView mv = new ModelAndView();
		
		//	view에 전달할 데이터 추가
		mv.addObject("id",id);
		mv.addObject("pw",pw);
		mv.addObject("dto", dto);
		
		// 이동할 view 이름 추가
		mv.setViewName("sample/pro");
		
		return mv;
		
		
	}
	
	
	@RequestMapping("pro3")
	public String pro3(@ModelAttribute("dto") SampleDTO dto, @ModelAttribute("id") String id , @ModelAttribute("pw") String pw) {
		
		
		return "sample/pro";
	}
	
	
	
	@RequestMapping("hello6")
	public String hello6() {
		log.info("hello6 매핑");
		
		return "sample/hello";
	}
	
	
	@RequestMapping("test")
	public String test() {
		log.info("test 매핑");
		
		return "sample/test";
	}
	
	
	
	/*
	@ModelAttribute("TV")		// 모든 view 페이지에 전달
	public SampleTV getTv(String col) {
		
		log.info("getTV 호출!!");
		SampleTV tv = new SampleTV();
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol(col);
		
		
		return tv;
	}
	@ModelAttribute		// 모든 view 페이지에 전달
	public SampleTV getTv2(String col, Model model) {
		
		log.info("getTV 호출!!");
		SampleTV tv = new SampleTV();
		tv.setPower(true);
		tv.setCh(10);
		tv.setCol(col);
		model.addAttribute("tv1",tv);
		model.addAttribute("tv2",tv);
		
		return tv;
	}
	 */
	
	
	
	@RequestMapping("hello7")
	@ResponseBody		// body 태그로 데이터 즉시 전달및 표기 //자바 스크립트 이용하여 메세지 요청할때
	//	view페이지로 응답X, 데이터 응답해줄때 주로 사용 (ajax 사용시)
	public String hello7() {
		
		return "hello............";
		
	}
	
//	@RequestMapping(value="hello8",params={"id=java"}  )
//	@RequestMapping(value="hello8",params={"id=java","pw=1234"}  )
//	@RequestMapping(value="hello8",params={"id=admin","pw"}  )	
	@RequestMapping(value={"hello8","hello9"},params={"id=admin","pw", "!age" } ,method= {RequestMethod.GET,RequestMethod.POST})	// 필수 파라미터 값의 구속조건
	public String hello8() {
		
		return "sample/test";
	}
	
	
	
	
	
	@RequestMapping("hello10")
//	public String hello10(@RequestParam(value="id", defaultValue = "lala" ) String msg ) {
//	public String hello10(@RequestParam(value="id",required = true) String msg ) {
	public String hello10(@RequestParam(value="id",required = true) String id ,
			@RequestParam(value="pw",required = true) String pw ,
			@RequestParam(value="auto",required = false ,defaultValue = "0")String auto	) {
							//	파라미터 이름으로 바인딩해줘야 msg에 제대로 바인딩된다
		log.info(id);
		log.info(pw);
		log.info(auto);
		
		return "sample/test";
	}
	
	
	
	
	
	
	
	
	
	
	
}
