<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br />
   	<h1 align="center"> Main page </h1>
	<c:if test="${sessionScope.memId == null }">
   	<table>
      <tr>
         <td><button onclick="window.location='/member/login'">로그인</button></td>
      </tr>
      <tr>
         <td><button onclick="window.location='/member/signup'">회원가입</button></td>
      </tr>
  	</table>
	</c:if>
	
	
	   
	<c:if test="${sessionScope.memId != null }">
   	<table>
      <tr>
         <td><button onclick="window.location='/member/logout'">로그아웃</button></td>
      </tr>
      <tr>
         <td><button onclick="window.location='/member/mypage'">마이페이지</button></td>
      </tr>
  	</table>
	</c:if>   
   
   	<br /><br />
   	<div align="center">
    	<img src="/resources/imgs/zzz.jpg" width="500" />
   	</div>
   	<br /><br />
</body>
</html>








