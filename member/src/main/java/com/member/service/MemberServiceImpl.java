package com.member.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.member.domain.MemberDTO;
import com.member.persistence.MemberMapper;

//	MemberService Implement
@Service		//	비즈니스 영역을 담당하는 객체임을 표시해줌
public class MemberServiceImpl implements MemberService{
	//	C --> S i --> S impl -- Mapper i -> Mapper.xml --> DB
	//  결과	  <--- 결과		<---		결과
	

	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public int addMember(MemberDTO member) {
		//	DB에 회원 정보 insert 해야함
		//	mapper에 메서드 호출해서 DB에 insert 하고 , 갱신된 레코드수 결과 리턴받기
		int result = mapper.insertMember(member);
		//	갱신 레코드수 리턴 받은 결과 서비스로 리턴하기
		return result;
	}


	@Override
	public int idPwCheck(MemberDTO member) {
		//	mapper한테 dto 전달하고 id,pw 확인 결과 가져와
		
		return mapper.idPwCheck(member);
	}
	
	
	
	@Override
	public MemberDTO getMember(String id) {
		//	DB가서 id 에 해당하는 회원 정보 다 가져오는 처리
		MemberDTO member = mapper.getMember(id);
		
		return member;	//	controller에게 리턴
				
	}


	@Override
	public int modifyMember(MemberDTO member) {
		
		//	id 필요 : session 꺼내기-> session 필요 -> request 꺼내기 -> request 필요
//		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//		ServletRequestAttributes sa = (ServletRequestAttributes)ra;
//		HttpServletRequest request = sa.getRequest();
		
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
//		String id = (String)session.getAttribute("memId");
		member.setId((String)session.getAttribute("memId"));
		
		//	id, pw 체크
		int checkResult = mapper.idPwCheck(member);
		//	맞으면 수정
		if(checkResult == 1) {
			mapper.updateMember(member);
		}
		return checkResult;		//	id pw 확인 결과 리턴
	}


	@Override
	public int deleteMember(MemberDTO member) {
		
		//	id,pw 체크하고
		int result = mapper.idPwCheck(member);
		//	일치하면 데이터 삭제처리, 로그아웃 처리
		if(result == 1) {
			mapper.deleteMember(member.getId());	//	삭제처리
			//	세션에서 memId라는 이름의 속성 삭제 (로그아웃)
			RequestContextHolder.getRequestAttributes().removeAttribute("memId", RequestAttributes.SCOPE_SESSION);
			//RequestContextHolder.getRequestAttributes().setAttribute("memId", member.getId(), RequestAttributes.SCOPE_SESSION);
			//== session.setAttribute("memId",member.getId());
		}
		
		
		return result;	//	id,pw 체크한 값 리턴
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
		
}
