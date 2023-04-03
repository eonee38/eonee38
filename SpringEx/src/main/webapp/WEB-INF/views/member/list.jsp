<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 화면(뷰) 만들기</title>
</head>
<body>
${memlist} 
	<table border="1">
		<tr>
			<td>ID</td><td>이름</td><td>이메일</td><td>폰번호</td><td>주소</td>
		</tr>
		<c:forEach items="${memlist}" var="list">
		<tr>
			<%-- <td>${memlist[0].id} </td><td>${memlist[0].name}</td><td>${memlist[0].birthday}</td><td>${memlist[0].gender}</td><td>${memlist[0].email}</td><td>${memlist[0].phone}</td> --%>
			<!-- 배열이니까 인덱스도 필요함! 어떤 걸 골라야 하는지 몰라서 오류발생하니까 --> 
			<!-- 배열의 길이만큼 반복(for문) -->
			<!-- JSTL로 forEach 만들어주기(+ 위에 JSTL 사용하려면 코드 추가 필수!-->
			<td><a href="detail?id=${list.id}">${list.id}</a></td>  <!-- a태그는 무조건 get방식. 자바스크립트 이용해야 post로 바꿀 수 있음 -->
			<td>${list.name}</td><td>${list.email}</td><td>${list.phone}</td><td>${list.addr}</td> 
		</tr>
		</c:forEach>
	</table>
<!--
 추가 실습 : http://localhost:8082/list(회원목록리스트)에서 ID를 클릭하면 그 회원의 상세내용을 알 수 있는 화면으로 이동함과 동시에 정보를 조회하고(select 결과 1건 - login을 참조)
그 화면에 수정과 삭제 버튼을 생성하여, 수정 및 삭제(회원가입 -insert를 참조)하도록 구현하라.-->
	
	
</body>
</html>