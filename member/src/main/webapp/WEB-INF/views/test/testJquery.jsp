<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>jquery</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>	
	<style type="text/css">
		.test{
			color : yellow;
		}
	</style>
</head>
<body>
	<h3>hello jquery</h3>
	<h3 id="h3id" class="cls1"> id selector</h3>
	<h3 class="cls1"> class selector</h3>
	
	<ul>
		<li>1111</li>
		<li>2222</li>
		<li>3333</li>
		<li>4444</li>
	</ul>
	
	<img src="/resources/imgs/zzz.jpg" width="400">
	<button class="btn">이미지 변경</button>
	
	<br> <br> <br>
	
	<h3> 입력값 확인하기 </h3>
	<input type="text" name="id" id="id">
	<button class="btn2"> 확인</button>
	
	<h2>과목선택</h2>
	<select>
		<option>java</option>
		<option>jsp</option>
		<option>framework</option>
		<option>project</option>
	</select>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script type="text/javascript">
	
		
		$(document).ready(function() {
			
			$("select").change(function () {
				alert($(this));
				$("h2").text($(this).val());
			});
			
			
			
			
	
			$(".btn2").click(function () {
				alert($("#id").val());
				$("h3").text("확인 완료!!");
				$("#id").val("");
			});
			
			
			
			
			$(".btn").click(function () {
				$("img").attr("src","/resources/imgs/yaba.png");
			})
			
			
			$("h3").css("color","red");			
			$("#h3id").css("color","blue");
			$(".cls1").css("color","green");
			
			$("li:nth-child(2)").css("color","magenta");
			$("li").attr("class","test");
			
		});
		
	</script>

</body>
</html>