<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- HEADER -->
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Board Modify</h1><br />
       
        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
            </div>
           <div class="card-body">
           		<form id="modifyForm" action="/board/modify" method="post">
                <div class="mr-3 ml-3 mb-4">
                    <div class="form-group row">
                       <label>Bno</label>
                        <input type="text" class="form-control" name="bno" value="${board.bno}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                       <label>Title</label>
                        <input type="text" class="form-control" name="title" value="${board.title}"/>
                    </div>
                    <div class="form-group row">
                       <label>Content</label>
                       <textarea class="form-control" rows="3" name="content">${board.content}</textarea>
                    </div>
                    <div class="form-group row">
                       <label>Writer</label>
                        <input type="text" class="form-control" name="writer" value="${board.writer}" readonly="readonly"/>
                    </div>
                    <div class="form-group row">
                       <label>Reg Date</label>
                        <input type="text" class="form-control" name="reg" value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${board.reg}" />' readonly="readonly"/>
                    </div>
                </div>
                 <div class="mr-1 ml-1">
						<button type="submit" data-service="modify" class="btn btn-danger">저장!</button>
						<button type="submit" data-service="delete" class="btn btn-warning">Delete</button>
						<button type="submit" data-service="list" class="btn btn-info" onclick="location.href='/board/list'"> List </button>
                 </div>
                 <%-- 이동시 들고갈 pageNum listQty 히든으로 추가 --%>
                 <input type="hidden" name="pageNum" value="${cri.pageNum }">
                 <input type="hidden" name="listQty" value="${cri.listQty }">
                 
                 </form>
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->                 




		<!-- 버튼에 따른 이벤트 처리 스크립트 추가 -->
		<script type="text/javascript">

		$(document).ready(function () {
			let formObj = $("#modifyForm");		// form 태그 가져오기
			$("button").on("click", function (e) {
				e.preventDefault();				//	기본 동작 취소 (submit의 이동기능 취소)
			//	console.log(e);
				let service = $(this).data("service");
			//	console.log(service);
				if(service =='delete'){
					formObj.attr("action","/board/delete");
				}else if(service == 'list'){
				//	formObj.attr("action","/board/list");
				
					//	list로 이동할 때는 폼태그 안에 있는 데이터 전부 보낼 필요X
					formObj.attr("action","/board/list").attr("method","get");
					
					//	pageNum과 listQty 히든 태그를 복사해놓고
					let pageNumTag =$("input[name='pageNum']").clone();
					let listQtyTag =$("input[name='listQty']").clone();
					
					//	내용물 전부 삭제하고
					formObj.empty();
					
					//	복사해둔거 추가한후
					formObj.append(pageNumTag);
					formObj.append(listQtyTag);
					//	submit()
				}
				
				//	js로 폼의 submit 버튼 누른 효과와 동일
				formObj.submit();
				
			});
		
		
		});
		</script>






<!-- FOOTER -->
<%@ include file="../includes/footer.jsp" %>

