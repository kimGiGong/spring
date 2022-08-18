package com.spring.mapper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.dto.SampleDTO;

public interface SampleMapper {
	
	//	test 테이블에서 전체 레코드 갯수 가져오는 쿼리문
	public int getCount();		//	인터페이스 중괄호X
	
	
	//	test테이블 age에서 가장 큰 수
	public int getMaxAge(); 

	
	//	test 테이블의 전체 레코드 가져오기
	public List<SampleDTO> getAllRecord();
	
	//	id 주고 id에 해당하는 레코드 한줄 가져오기
	public SampleDTO getOneRecord(String id);
	
	
	//	id 주고 id에 해당하는 reg컬럼값 가져오기
	public Timestamp getRegById(String id);
	
	//	test 테이블에 회원 정보 전달해서 저장시키기
	public int insertRecord(SampleDTO dto);
	
	
	//	test 테이블에서 dto 전달하여 수정하기
//	public int updateRecord(SampleDTO dto);
	public int updateRecord(@Param("id")String id, @Param("pw")String pw, @Param("age")int age);
	public int updateRecord2(HashMap data);
	
	
	//	id(PK) 주고 레코드 삭제
	public int deleteRecord(String id); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
