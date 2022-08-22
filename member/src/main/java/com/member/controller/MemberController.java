package com.member.controller;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.member.domain.MemberDTO;
import com.member.service.MemberService;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.h;

@Controller
@RequestMapping("/member/*")
@Log4j
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("signup")
	public void signupForm() {
	
		
		
	}
	@PostMapping("signup")
	public String signupPro(MemberDTO member , Model model) {
		
		log.info(member);
		//	회원가입 로직 처리 -> Service
		
		int result = service.addMember(member);
		//	처리된 결과 views에 전달
		model.addAttribute("result",result);
		
		return "member/signupPro";
	}
	
	
	
	@GetMapping("main")
	public void main() {
		
	}
	
	
	@GetMapping("login")
	public void login() {
		
	}
	@PostMapping("login")
	public String loginPro(MemberDTO member, String auto , Model model , HttpSession session) {
		
		log.info(member);
		log.info(auto);
		//	비지니스 로직
		int result = service.idPwCheck(member);
		if(result == 1) {
			session.setAttribute("memId",member.getId());
			return "redirect:/member/main";		//	컨트롤러에 재요청하여 메인으로 바로 이동시키기
			}else {
			model.addAttribute("result" , result);	//	결과 pro 페이지로 전달
			return "member/loginPro";
		}
	}
	
	
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		
		//	로그아웃 처리
		session.invalidate();
		
		return "redirect:/member/main";
	}
	
	
	@GetMapping("mypage")
	public void mypage(){
		
	}
	
	
	
	
	@GetMapping("modify")
	public void modify(HttpSession session, Model model){
		
		//	회원정보 가져와 view에 전달후 , 수정 폼페이지로 이동
		String id = (String)session.getAttribute("memId");	//	세션에서 사용자 아이디 꺼내기
		MemberDTO member = service.getMember(id); 
		
		log.info(member);
		
		model.addAttribute("member",member);	//	view에 전달하기
		
	}
	
	
	
	
	@PostMapping("modify")
	public String modifyPro(MemberDTO member, HttpSession session, Model model) {
		
		//	member.setId((String)session.getAttribute("memId"));	가장 쉬운방법
		
		
		//	비지니스 로직 처리 : id , pw 일치하는지 체크후 일치하면 수정
		int result = service.modifyMember(member);	//	id,pw 체크한 결과 1= 일치, 0 = 불일치
		model.addAttribute("result", result);
		
		return "member/modifyPro";
	}
	
	
	
	
	@GetMapping("delete")
	public void delete() {
	}
	
	@PostMapping("delete")
	public String deletePro(MemberDTO member , HttpSession session, Model model) {
		String id = (String) session.getAttribute("memId");
		member.setId(id);
		//	비지니스 로직 처리 : id,pw 주고 일치하면 데이터 삭제 (로그아웃도 해주고)
		int result = service.deleteMember(member);
		if(result == 1) {
//			session.removeAttribute("memId");
		}
		model.addAttribute("result" , result);
		
		return "member/deletePro";
	}
	
	
	
	
	//	ajax로 id 중복여부 체크하는 요청 매핑 추가
	@PostMapping("idAvail")
	public ResponseEntity<String> idAvail(MemberDTO dto) {
		// System.out.println("id : "+id);
		System.out.println(dto);
		int result = service.idPwCheck(dto);
		System.out.println("result : "+result );
		//	result == 1 : 이미 존재함
		//	result == 0 : 사용가능한 아이디
		String data = null;		//	jsp-ajax-success 함수 매개변수에 전달할 결과 변수
		if(result == 1) {
			data = "사용 불가능";
		}else {
			data = "사용가능 ok";
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain;charset=UTF-8");
		
		return new ResponseEntity<String>(data,headers,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



