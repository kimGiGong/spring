<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/resources/member/css/style.css" rel="stylesheet" type="text/css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>	
</head>
<body>

	<%-- 로그아웃 처리용 form 태그 --%>
	<form action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>
	
	<%-- 처리결과 분기 처리 --%>
	<c:if test="${result == 1}">
		<script type="text/javascript">
			$(document).ready(function () {
				let formObj = $("form");
				alert("회원 탈퇴 완료");
				formObj.submit();
			});
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