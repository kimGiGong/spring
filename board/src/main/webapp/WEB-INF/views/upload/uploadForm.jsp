<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UploadForm</title>
</head>
<body>

	<form action="/upload/uploadPro" method="post" enctype="multipart/form-data">
		massage : <input type="text" name="msg" > <br>
		file	: <input type="file" name="img" > <br>
				<input type="submit" value="전송">
		
	</form>

</body>
</html>