package com.member.service;

import com.member.domain.MemberVO;

public interface MemberService {

	//	회원가입 (추가)
	public int addMember(MemberVO member);
	//	권한 추가
	public int addAuth(String auth,String id);
	
	
	//	회원 정보 가져오기
	public MemberVO getMember(String id);
	
	
	//	회원정보 수정처리
	public int modifyMember(MemberVO member);
	
	
	//	회원탈퇴 처리
	public int deleteMember(MemberVO member);
}
