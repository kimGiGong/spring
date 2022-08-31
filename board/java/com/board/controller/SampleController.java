package com.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.domain.Bank;
import com.board.domain.SampleVO;

import lombok.extern.log4j.Log4j;

/*
	produces : 서버에서 생산하여 브라우저에 리턴해주는 데이터의 형태를 지정
				브라우저에서 요청시 지정한 accept 요청 헤더값과 일치
	consumes : 브라우저에서 요청시 지정한 Content-Type 과 일치하게 작성. (브라우저 -> 서버)


*/

@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	
	
	
	
	//	단순 문자열 리턴 (view페이지 상관X 데이터 전송!)
	@GetMapping(value="getText", produces="text/plain;charset=UTF-8")
	public String getText() {
		log.info("************ Hello getText *******");
		log.info("************ "+MediaType.TEXT_PLAIN_VALUE +" *************");
		
		//	기존의 @Controller는 문자열을 리턴하는 경우 JSP 파일 이름으로 처리하지만,
		//	@RestController의 경우에는 순수한 데이터가 리턴된다.
		//	produces="text/plain;charset=UTF-8" 속성은 해당 메서드가 생산하는 MINE 타입을 의미함
		//	위와 같이 문자열을 직접지정할 수도 있고, MediaType이라는 클래스를 이용할 수도 있다.
		
		return "안녕하세요";
	}

	
	

	
	//	객체 리턴(produces 생략도 가능)	(XML 파일) 주소에 .json 추가시 보기형태 json으로 변경 
	@GetMapping(value="getVO",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getVO() {
		
		log.info("****** Hello getVO *********" );
		
		return new SampleVO(111,"간첩","영등포경찰서");
		
	}
	
	
	
	
	
	//	컬렉션 타입 리턴 : List
	@GetMapping("getList")
	public List<SampleVO> getList(){
		
		List<SampleVO> list = new ArrayList<SampleVO>();
		for (int i = 1; i <= 10; i++) {
			list.add(new SampleVO(i,"Name"+i,"Addr-"+i));			
		}
		
		return list;
	}
	
	
	
	//	컬렉션 리턴 타입 : Map
	@GetMapping("getMap")
	public Map<String,SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("one", new SampleVO(111,"간첩","평양"));
		
		return map;
	}
	
	
	
	
	
	//	ResponseEntity 타입 리턴		:: header + 데이터 를 같이 넘길수 있다.
	
	@GetMapping(value="gradeCheck",params={"eng","math"})	//	필수 요청 파라미터 지정	(없으면 400에러)
	
	public ResponseEntity<SampleVO> getGradeCheck(int eng , int math){
		
		//	영어와 수학 점수를 요청 파라미터로 받아서 , 60점 미만이면 상태코드 에러전송.
		SampleVO vo = new SampleVO( 0 , eng+"" , math+"" );
		
		ResponseEntity<SampleVO> result = null; 
		
		if(eng < 60 || math < 60) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
										//	상태코드 502 추가	// body 데이터 추가
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
									//	상태코드 200 	// body 데이터 추가
			
		}
		
		return result; 
	}
	
	
	
	
	
	//	@PathVariable 사용
	@GetMapping("/news/{cat}/{nid}")
	//@GetMapping("/board/{bno}")
	public String[] getPathVar(int testNum, @PathVariable("cat") String cat, @PathVariable("nid") Integer nid) {
		
		log.info("*********** pathvariable ******");
		log.info("*********** category ******"+cat);
		log.info("*********** nid ******"+nid);
		log.info("*********** testNum ******"+testNum);
		
		return new String[] {"category : "+ cat, "news id : "+ nid};	//	문자열 2개를 배열로 리턴
	}
	
	
	
	
	//	@RequestBody	: 요청시 데이터를 JSON으로 보내고, 여기 서버에서 Bank 자바 객체로 변환해 받기
	@PostMapping(value="bank",consumes = "application/json")
	public Bank convertBank(@RequestBody Bank bank) {
		
		log.info("convert to Bank obj : "+bank);
		
		return bank;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
