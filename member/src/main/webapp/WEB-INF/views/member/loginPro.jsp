<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login pro</title>
</head>
<body>
	<h1>login Pro</h1> 
	<c:if test="${result ==0 }">
		<script type="text/javascript">
			alert("id 또는 pw 불일치");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>