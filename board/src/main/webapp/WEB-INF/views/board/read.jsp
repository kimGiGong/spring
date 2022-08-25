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
						<button class="btn btn-danger" onclick="location.href='/board/modify?bno=${board.bno}&pageNum=${cri.pageNum}&listQty=${cri.listQty}'">발사!</button>
						<button class="btn btn-info" onclick="location.href='/board/list?pageNum=${cri.pageNum}&listQty=${cri.listQty}'"> List </button>
                 </div>
            </div>
        </div>
        <!--  content 내용물 끝나는 부분  -->                 











<!-- FOOTER -->
<%@ include file="../includes/footer.jsp" %>



















