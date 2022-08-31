<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="/resources/member/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br />
   	<h1 align="center"> Main page </h1>
   	
   	<sec:authorize access="isAnonymous()">
   	<table>
      <tr>
         <td><button onclick="window.location='/common/login'">로그인</button></td>
      </tr>
      <tr>
         <td><button onclick="window.location='/common/signup'">회원가입</button></td>
      </tr>
      <tr>
         <td><button onclick="window.location='/board/list'">게시판</button></td>
      </tr>
  	</table>
   	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
	로그인 상태 <br>	   
   	<table>
      <tr>
         <td>
         	<%-- 시큐리티로 로그아웃 : /logout Post 요청 , csrf 토큰 필수 --%>
         	<form action="/logout" method="post">
         	   	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> <%-- 시큐리티 토큰 --%>
	        	<button>로그아웃</button>
         	</form>
         </td>
      </tr>
      <tr>
         <td><button onclick="window.location='/member/mypage'">마이페이지</button></td>
      </tr>
      <tr>
         <td><button onclick="window.location='/board/list'">게시판</button></td>
      </tr>
  	</table>
  	<h3>사용자 정보 출력</h3>
  	<table>
  		<tr>
			<td>pricipal</td>
			<td><sec:authentication property="principal"/></td>	<%-- principal = CustomUser 클래스 를 의미함 --%>
  		</tr>
  		<tr>
			<td>MemberVO</td>
			<td><sec:authentication property="principal.member"/></td>
  		</tr>
  		<tr>
			<td>사용자 이름</td>
			<td><sec:authentication property="principal.member.name"/></td>
  		</tr>
  		<tr>
			<td>사용자 ID</td>
			<td><sec:authentication property="principal.username"/></td>
  		</tr>
  		<tr>
			<td>권한 리스트</td>
			<td><sec:authentication property="principal.member.authList"/></td>
  		</tr>
  	</table>
  	
	</sec:authorize>
   
   	<br /><br />
   	<div align="center">
    	<img src="/resources/member/imgs/zzz.jpg" width="500" />
   	</div>
   	<br /><br />
</body>
</html>
