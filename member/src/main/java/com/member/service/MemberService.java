package com.member.service;

import com.member.domain.MemberDTO;

public interface MemberService {
	
	//	회원 가입 처리
	public int addMember(MemberDTO member);
	
	//	id, pw 확인
	public int idPwCheck(MemberDTO member);
	
	//	회원 한명 정보 가져오기
	public MemberDTO getMember(String id);
	
	//	회원 정보 수정 처리
	public int modifyMember(MemberDTO member); 
	
	//	회원 한명 정보 삭제하기
	public int deleteMember(MemberDTO member); 
}
