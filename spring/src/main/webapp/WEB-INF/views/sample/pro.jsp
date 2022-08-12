<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>process</title>
</head>
<body>
	<h2> pro page </h2>

	
	<h3> id : ${id}</h3>
	<h3> pw : ${pw}</h3>
	
	
	<h3> req id : ${reqId}</h3>
	<h3> req pw : ${reqPw}</h3>
	
	
	<h3> dto.id : ${dto.id}</h3>
	<h3> dto.pw : ${dto.pw}</h3>
	<h3> dto.getId : ${dto.getId()}</h3>
	<h3> dto.getPw() : ${dto.getPw()}</h3>
	
	<h3> dto : ${dto}</h3>
	
	객체 첫번째 글자 소문자로 변환됨 
	<h3> sampleDTO : ${ samdto }</h3>
	<h3> sampleDTO : ${ samdto.id }</h3>
	<h3> sampleDTO : ${ samdto.pw }</h3>
	
	


</body>
</html>