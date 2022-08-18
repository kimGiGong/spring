package com.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	//	select 문으로 DB에서 현재 시간 가져오는 작업 예시

	//	어노테이션 이용하여 SQL문 실행
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	
	//	XML+ 인터페이스 같이 사용
	public String getTime2();
	
	
	
	
	
}
