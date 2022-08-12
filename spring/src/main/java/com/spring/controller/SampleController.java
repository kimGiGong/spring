package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// 상속받는다면 맵핑주소 달라도 같은 페이지 이동가능?
@Controller	//	컨트롤러 역할을 하는 클래스로 선언
			//	자동으로 스프링객체(스프링빈 == 객체생성) 등록되게 해줌
@RequestMapping("/sample/*")	//	해당클래스 안에 있는 모든 주소 앞에 공통 주소로 적용
public class SampleController {
	
	//	매핑 메서드 작성
	//	@RequestMapping(value="hello"/*, method = {RequestMethod.GET , RequestMethod.POST}*/)
	//	@RequestMapping({"hello","test"})	//	하나의 메서드에 여러개 주소 매핑
	//	@RequestMapping("content/{bno}")	//	주소 자체를 값으로 꺼낼때 사용
	//	public String hello(@PathVariable("bno") String val) {
	
	@RequestMapping("?") // ? 하나가 한글자
	public String hello() {
		
		System.out.println("hello 매핑 메서드 호출!!!");
		//	System.out.println("val : " + val);
		
		return "sample/hello"; // 요청 들어왔을때 보여줘야하는 view 이름
	}
	
	/*	와일드 카드로 URL 매핑
	@RequestMapping("*")
	public String hello2(){
		System.out.println("***********************");
		return "sample/hello";
	} */
	
	@RequestMapping(value = "hello2", method= { RequestMethod.POST })
	public String hello2(){
		System.out.println("hello2 GET!!!!!!!!!!!!!!!!!");
		return "sample/hello";
	}
	//	get방식 요청만 받는 매핑
	@GetMapping(value = "hello3")
	public String hello3(){
		System.out.println("hello 3 GET!!!");
		return "sample/hello";
	}
	//	Post방식 요청만 받는 매핑
	@PostMapping(value = "hello3")
	public String hello3Post(){
		System.out.println("hello 3 Post!!!");
		return "sample/hello";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
