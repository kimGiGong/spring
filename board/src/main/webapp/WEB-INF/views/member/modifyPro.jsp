<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			alert("회원정보 수정완료");
			window.location = "/member/mypage";
		</script>
	</c:if>
	
	<c:if test="${result != 1}">
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다. 다시 시도");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>