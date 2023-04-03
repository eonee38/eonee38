<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<!-- Spring 프레임워크 사용방법/ 내부스타일시트 역시 head태그 사이에 태그 넣고 기술하면 됨-->
	<!-- css태그로 기술-->
	<!-- javascript태그로 기술 -->
	
	<!-- 만약에 외부스타일시트면? 폴더를 어디에 생성? -> webapp -> resources폴더 ->  css / img / js 로 폴더 만들어서 이용하면 됨  -->
	
</head>
<body>
<h1>
	Hello world!  
</h1>
Main page입니다.<br><br>
<input type=button value="로그인 하러가기" onclick="location.href='http://localhost:8082/login'"> <!-- post방식은 get임(생략) -->
<a href="login">로그인하러 가기</a> <!-- a태그로도 가능!!  서버주소는 앞에 고정이라서 뒤에 login만 써주면 됨 -->

</body>
</html>
