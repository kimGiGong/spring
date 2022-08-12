<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>form jsp</title>
</head>
<body>

	<h1> form page </h1>
	<form action="/sample4/login" method="post">
		id: <input type="text" name="id" /> <br>
		pw: <input type="password" name="pw" /> <br>
			<input type="submit" value="로그인" /> <br>
	</form>
	
	
	<h3>임시로 주석처리 시킴</h3>
	<h3>power : ${TV.power}</h3>
	<h3>ch : ${TV.ch}</h3>
	<h3>vol : ${TV.col}</h3>
	<h3>sampleTV power : ${sampleTV.power}</h3>
	<h3>sampleTV ch : ${sampleTV.ch}</h3>
	<h3>sampleTV vol : ${sampleTV.col}</h3>
	
</body>
</html>