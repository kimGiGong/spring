<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>signup pro</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br>
	<c:if test="${result == 1}">
		<h2 align="center">회원가입 성공!!</h2>
		<div align="center">
			<button onclick="window.location='/member/main'">메인으로</button>
		</div>	
	</c:if>
	<c:if test="${result != 1 }">
		<script type="text/javascript">
			alert("회원가입이 정상적으로 처리되지 않았브니다. 다시 시도해주세요.");
			history.go(-1);
		</script>	
	</c:if>
	<h1> signup pro </h1>
	<h2> result : ${result} </h2>
</body>
</html>



