package com.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.member.domain.AuthVO;
import com.member.domain.MemberVO;
import com.member.persistence.MemberMapper;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.m;

@Service
@Log4j
public class MemberServiceImpl implements MemberService {

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public int addMember(MemberVO member) {
		log.info("************************* service Add Member pw Before : " +member.getPw());
		member.setPw(bcryptPasswordEncoder.encode(member.getPw())); 
		log.info("************************* service Add Member pw After : " +member.getPw());
		
		return mapper.addMember(member); 
	}

	@Override
	public int addAuth(String auth, String id) {
		int result = -1;
		AuthVO authVO = new AuthVO();
		authVO.setId(id);
		if(auth.equals("member")) {			//	일반회원 가입시 권한 추가
			authVO.setAuth("ROLE_MEMBER");
			result = mapper.addAuth(authVO);
		}else if(auth.equals("admin")) {	//	관리자로 가입시 권한추가
			authVO.setAuth("ROLE_MEMBER");
			result = mapper.addAuth(authVO);
			authVO.setAuth("ROLE_ADMIN");
			result = mapper.addAuth(authVO);
		}
		
		return result;
	}

	@Override
	public MemberVO getMember(String id) {
		return mapper.getMember(id);
	}

	@Override
	public int modifyMember(MemberVO member) {
		//	id pw 체크 추가
		int result =0;
		MemberVO dbMember = getMember(member.getId());
		if(bcryptPasswordEncoder.matches(member.getPw(), dbMember.getPw())) {
			result = mapper.updateMember(member);
		}
		
		return result;
	}

	@Override
	public int deleteMember(MemberVO member) {
		//	id pw 체크 추가
		int result = 0;
		MemberVO dbMember = getMember(member.getId());
		if(bcryptPasswordEncoder.matches(member.getPw(),dbMember.getPw())) {
			result =1;
			int deleteRes = mapper.deleteAuth(member.getId());
			log.info("*********** delete member auth res : " + deleteRes);
			deleteRes = mapper.deleteMember(member.getId());
			log.info("*********** delete member res : " + deleteRes);

		}
		return result;
	}

}
