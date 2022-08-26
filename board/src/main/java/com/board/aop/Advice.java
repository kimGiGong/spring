package com.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.log4j.Log4j;

//	공통기능 구현해 놓을 클래스
// Joinpoint에 삽입 되어져 동작할 수 있는 코드를 "언제" 공통기능을 핵심로직에 적용할 지를 적용하고 있다.
@Log4j
public class Advice {
	
	public void before() {
		log.info("===== befor advice ======");
		log.info("===== befor advice ======");
		log.info("===== befor advice ======");
	}
	public void afterAop() {
		log.info("===== afterAop advice ======");
		log.info("===== afterAop advice ======");
		log.info("===== afterAop advice ======");
	}
	public void afterReturning() {
		log.info("===== afterReturning advice ======");
		log.info("===== afterReturning advice ======");
	}
	public void afterThrowing() {
		log.info("===== afterThrowing advice ======");
		log.info("===== afterThrowing advice ======");
	}

	
	/*
	around advice 메서드 구현방법
	첫번째 매개변수
	리턴타입 Object 타입으로 , 가던길 가라 (타겟으로~) j.proceed() 호출하여
	리턴받은 값을 리턴해주는 형태로 작성해야함.
	*/
	public Object around(ProceedingJoinPoint j) throws Throwable {
		log.info("===== around before 발생 !! ======");
		
		Object obj = j.proceed();	//	가던길 가라(Target)
		
		log.info("===== around after 발생 !!  ======");
		return obj;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
