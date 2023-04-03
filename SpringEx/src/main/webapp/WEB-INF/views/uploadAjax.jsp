<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/resources/js/uploadAjax.js"></script><!-- 외부 자바스크립트 연결(폴더확인) -->
</head>
<body>
<div>
		<input type="file" name="uploadFile" multiple >
</div>
<div>		
		<input type="button" id="uploadBtn" value="파일전송">
</div>
<div id="uploadResult">
	<ul>
		
	</ul>	
</div>		
</body>
</html>