<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HEADER -->
<%@ include file="../includes/header.jsp" %>



<!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Board Read</h1><br />
       
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
            </div>
           <div class="card-body">
                <div class="mr-3 ml-3 mb-4">
                    <div class="form-group row">
                       <label>Bno</label>
                        <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                       <label>Title</label>
                        <input type="text" class="form-control" name="title" value="${board.title}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                       <label>Content</label>
                       <textarea class="form-control" rows="3" name="content" readonly="readonly">${board.content}</textarea>
                    </div>
                    <div class="form-group row">
                       <label>Writer</label>
                        <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly"/>
                    </div>
                </div>
                 <div class="mr-1 ml-1">
						<button class="btn btn-danger" data-service="modify">발사!</button>
						<button class="btn btn-info" data-service="list"> List </button>
                 </div>
                 <form id="btnForm" action="/board/modify" method="get">
                 	<input type="hidden" name="bno" value="${board.bno}" id="bno">
                 	<input type="hidden" name="pageNum" value="${cri.pageNum}">
                 	<input type="hidden" name="listQty" value="${cri.listQty}">
                 	<input type="hidden" name="sel" value="${cri.sel}">
                 	<input type="hidden" name="keyword" value="${cri.keyword}">
                 </form>
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->
        
        
        <!-- 댓글 css 약식 -->
        <style> 
           .reply_container {
              margin: 0.5rem auto; 
              display: flex;
              flex-direction: column; 
           }
           .reply_li {
              margin: 1rem 0; 
              display: flex; 
              flex-direction: column;
              width: 100%;
           }
           .replyer_reg_ctn {
              margin: 0.4rem 0; 
              display: flex; 
              flex-direction: row; 
              justify-content: space-between;
              width: 100%; 
           }
           .reply_div {
              font-size: 1rem;
              width: 100%; 
           }
           .replyer_div {
              font-weight: bold;
              font-size: 0.9rem;
           }
           .replyReg_div {
              font-size: 0.7rem; 
           }
           .reply_inputbox {
              display: flex; 
              flex-direction: column;
              font-size: 0.7rem;
              width: 100%; 
           }
           .rbox_div {
              margin: 0.2rem 0; 
                width: 100%; 
           }
        </style>

        
        
        
        
		<!-- 댓글 DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Reply</h6>
            </div>
            <div class="card-body">
                <div class="mr-3 ml-3 mb-4">
                   <div class="reply_container">
                         <div class="reply_li">
                            <div class="replyer_reg_ctn">
                                <div class="replyer_div">replyer </div>
                                <div class="replyReg_div">2022.08.31</div>
                             </div>
                             <div>
                                <div class="reply_div">reply : 댓글내용.......................</div>
                             </div>
                          </div>
                          
                          <div class="reply_li">
                            <div class="replyer_reg_ctn">
                                <div class="replyer_div">replyer </div>
                                <div class="replyReg_div">2022.08.31</div>
                             </div>
                             <div>
                                <div class="reply_div">reply : 댓글내용.......................</div>
                             </div>
                          </div>
                    </div>
                    <hr />
                    <div class="reply_inputbox form-group">
					<!-- <form id="replyForm"> -->
                        <div class="rbox_div"><textarea id="reply" class="form-control" rows="3" name="reply" placeholder="댓글작성.."></textarea></div>
                        <div class="rbox_div"><input id="replyer" type="text" class="form-control" name="replyer" placeholder="작성자"/></div>
                        <div class="rbox_div"><button id="saveReplyBtn" type="button" class="btn btn-warning">Save Reply</button></div>
                    <!-- </form> -->
                    </div>
                </div>
            </div>
        </div> <!-- end 댓글card -->
        <!--  댓글 reply 끝나는 부분  -->
        
        <!-- 댓글 script -->
        <script type="text/javascript">
		$(document).ready(function () {
			let bnoVal = "${board.bno}";	//	 본문 글 고유번호
			console.log("bnoVal : "+bnoVal);						
			
			let replyContainer = $(".reply_container");		// 댓글 목록 담을 컨테이너 div
			
			showReplyList();	//	댓글 목록 가져와 뿌리기 호출
			
			//	댓글 목록 가져와 뿌려주기 함수 (페이징처리 X)
			function showReplyList() {
				
				console.log("show reply list 호출!");
				
				//	전체 댓글 가져오기 요청
				$.ajax({
					type : "GET",
					url : "/reply/list/"+bnoVal+".json",
					data: {bno:bnoVal},
					success : function (result) {
						console.log("요청 성공!");
						/*
						console.log(result);
						console.log(result[0].repno);
						console.log(result[0].bno);
						console.log(result[0].reply);
						console.log(result[0].replyer);
						console.log(result[0].reg);
						*/
						
						//	result 리스트 넘겨주기
						makeList(result);
						
						
					},
					error: function name(e) { 
						console.log("요청 실패...");
						console.log(e);
					}
					
				});
				
			}	//	showReplyList(){}
			
			
			//	댓글 목록 만들어서 화면에 부착 함수
			function makeList(result) {
				console.log("makeList!!");
				console.log(result);

				//	댓글이 없을 경우
				if(result == null || result.length == 0){
					//	댓글 목록에 아래와 같이 태그 부착하고
					replyContainer.html("<div class='reply_li'>댓글이 없습니다<div>");
					return;	//	makeList 함수 강제 종료	
				}
				
				
				//	부착할 목록 문자열로 만들기
				let str = "";
				for(let i = 0 ; i< result.length; i++){
					/*
						<div class='reply_li'><div class='replyer_reg_ctn'>
						<div class='replyer_div'>replyer </div>
						<div class='replyReg_div'>2022.08.31</div></div>
						<div><div class='reply_div'>reply : 댓글내용.......................</div></div></div>
					*/
					str += "<div class='reply_li'><div class='replyer_reg_ctn'>";
					str += "<div class='replyer_div'>"+result[i].replyer+"</div>";
					str += "<div class='replyReg_div'>"+timeFormat(result[i].reg)+"</div></div>";
					str += "<div><div class='reply_div'>"+result[i].reply+"</div></div></div>";
				}
				
				replyContainer.html(str);	//	html 부착
				
			}
			
			
			
			//	시간 함수 : 오늘 댓글은 시간, 오늘 이전 댓글은 날짜
			function timeFormat(regVal) {
				let today = new Date();
				let diff = today.getTime() -regVal;
				let dateObj = new Date(regVal);
				if(diff < (1000*60*60*24)){	// 24h 보다 작으면
					let hh = dateObj.getHours();
					let mi = dateObj.getMinutes();
					let ss = dateObj.getSeconds();
					return (hh > 9 ? "" : "0") + hh +":"
						+ (mi> 9 ? "" : "0") + mi + ":"
						+ (ss> 9 ? "" : "0") + ss;
				}else{
					let yy = dateObj.getFullYear();
					let mm = dateObj.getMonth()+1;
					let dd = dateObj.getDate();
					return yy + "/" + (mm > 9 ? "" : "0") + mm + "/" + (dd > 9 ? "":"0") + dd;

				}
				
			}
			
			
			
			
			
			
			// 댓글 저장버튼 이벤트 등록
			$("#saveReplyBtn").on("click", function (e) {	
				console.log("save button click!!");
//	불필요		let replyForm = $("#replyForm");
				//	console.log(replyForm);
				
				//	보낼 데이터 js객체로 만들기
				let replyVal = $("#reply").val();
				let replyerVal= $("#replyer").val();
				console.log("replyVal : "+replyVal);
				console.log("replyerVal : "+replyerVal);
				
				//	보낼 데이터 JS 객체로 만들고
				let reqData = { reply : replyVal, replyer : replyerVal , bno : bnoVal};
				console.log(reqData);
				
				
				$.ajax({
					type : "POST",
					url	: "/reply/add",
					data : JSON.stringify(reqData),
					contentType : "application/json;charset=utf-8",
					success: function(result, status, xhr){
						console.log("요청 성공!!");
						console.log(result);
						console.log(result.bno);
						console.log(result.reply);
						console.log(result.replyer);
						showReplyList();
					},
					error : function(e){
						console.log("요청 에러!!!!!");
						console.log(e);
					}
				});	//	ajax
				
			});	//	saveReplyBtn click
			
		});	// ready
		</script>
        
        
        
        
        
        
        
        
        
        
        
        
    <%-- script 태그 --%>                 
	<script type="text/javascript">
	$(document).ready( function () {
		let btnForm = $("#btnForm");
		$("button[data-service='modify']").on("click", function () {
			btnForm.attr("action","/board/modify").submit();
		});
		$("button[data-service='list']").on("click", function () {
			btnForm.find("#bno").remove();	//	bno 히든태그 삭제
			btnForm.attr("action","/board/list");	//	action 속성값 list 로 변경
			btnForm.submit();
		});
	});
	
	
	</script>










<!-- FOOTER -->
<%@ include file="../includes/footer.jsp" %>



















