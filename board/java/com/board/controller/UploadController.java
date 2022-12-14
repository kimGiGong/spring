package com.board.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/upload/*")
@Log4j
public class UploadController {

	@GetMapping("uploadForm")
	public void upload() {
		log.info("upload form!!!");
	}
	
	@PostMapping("uploadPro")
	public void uploadPro(String msg, MultipartHttpServletRequest request) { //	msg(text) , img(file)
		
		log.info("upload Pro");
		log.info("massage = "+msg);
	
		
		try {
			//	전송한 파일 정보 꺼내기 
			MultipartFile mf = request.getFile("img");
			log.info("original file name : =========="+mf.getOriginalFilename());
			log.info(" file size : =================="+mf.getSize());
			log.info(" file contentType : ==========="+mf.getContentType());
			
			
			//	파일 저장 경로 구하기
			String path = request.getRealPath("/resources/save");	// 서버상 save 폴더위치
			log.info("ppppaaatttthhhh == save path :   "+path);
			
			
			//	파일 저장시킬 새 파일명 생성
			String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
			log.info("Random id 생성!!!"+uuid);
			
			//	업로드한 파일 확장자만 가져오기
			String orgName = mf.getOriginalFilename();
			String ext = orgName.substring(orgName.lastIndexOf("."));
			log.info("확장자명: "+ext);
			
			//	저장할 파일명
			String newFileName = uuid+ext;
			log.info("NewFileName : "+newFileName);
			
			//	저장할 파일 전체 경로
			String imgPath = path+"\\"+newFileName;
			log.info("img Path : "+imgPath);
			
			
			//	파일 저장
			File copyFile = new File(imgPath);
			mf.transferTo(copyFile);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//	다운로드 버튼 띄운 화면
	@GetMapping("helloDown")
	public void helloDown() {
		
	}
	
	//	다운 요청 처리
	@GetMapping("download")
	public ModelAndView down(int fileNum) {
		//	다운시킬 파일 준비
		File f = null;
		if(fileNum == 1) {
			f = new File("D:\\pic\\yaba.png");
		}
		if (fileNum == 2) {
			f = new File("D:\\pic\\yaba.png");
		}else {
			f = new File("D:\\pic\\yaba.png");
		}
		
		//	생성자 매개변수
		//	String viewName 	: view 이름 -> xml 지정한 DownloadView 빈의 id값
		//	String modelName	: 파라미터명 지정 (이름)
		//	Object modelObject	: 데이터 (다운시킬 파일)
		ModelAndView mv = new ModelAndView("fileDown","downloadFile",f);	// new ModelAndView("bean객체이름","넣어줄 객체이름","value");
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
