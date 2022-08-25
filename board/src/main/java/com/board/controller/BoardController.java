package com.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;
import com.board.domain.PageDTO;
import com.board.service.BoardService;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.GetProxy;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("list")
	public void list(Model model,Criteria cri) {
		log.info("list 호출");
		//	model로 list jsp에 뿌려줄 글 목록 전달
		model.addAttribute("list",service.getList(cri));
		
		int total = service.getTotal(cri);	//	게시글의 갯수 가져오기
		log.info("================="+total+"==================");
		
		model.addAttribute("pager",new PageDTO(cri, total));
	}

	
	@GetMapping({"read","modify"})
	public void read(Long bno , Model model ,@ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board",service.get(bno));
	}
	
	
	
	@PostMapping("modify")
	public String modify(BoardVO board, Criteria cri ,RedirectAttributes rttr ) {
		//	수정 처리
		if(service.modify(board)) {
			log.info("수정 성공ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list"+cri.getListLink();
	}
	
	@PostMapping("delete")
	public String delete(Long bno,Criteria cri, RedirectAttributes rttr) {
		//	삭제처리
		if(service.delete(bno)) {
			log.info("================삭제성공=====================");
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list"+cri.getListLink();
	}
	
	
	//	글 등록 폼
	@GetMapping("write")
	public void write() {
		
	}
	
	//	글 등록 처리
	@PostMapping("write")
	public String writeBoard(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		log.info("write 처리!" + board);
		
		service.register(board);
		//	RedirectAttributes : Model처럼 스프링MVC가 자동으로 전달해주는 객체
		//	addFlashAttribute(key,value) : url 뒤에 데이터가 붙지 않고,
		//					일회서 데이터로 페이지 새로고침하면 데이터 날라감.
		//					값 1개만 전달 가능 , 2개이상은 데이터가 소멸하므로 Map이용해 한번에 보내야함
		//	addAttribute(key,value)
		//	위와 같은 메서드를 이용하여 리다이렉트 되는 jsp 페이지에 데이터 전달 할 수 있다.
		
		rttr.addFlashAttribute("result", board.getBno());
		//	등록처리후 글 고유번호 속성으로 추가해서 전달 (list에서 사용  )
		
		return "redirect:/board/list"+cri.getListLink();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
