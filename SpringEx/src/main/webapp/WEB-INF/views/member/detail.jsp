<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
id는 기본키라서 무조건 한건만 나옴. 중복불가 (select) 
DB에서 select한 데이터를  브라우저까지 끌고올 때는 리턴return에
 의해서 가져옴!
void면 리턴이 없으니까 싹 다 바꿔주기!!!!!!
-->
${detail}
<%-- <table border="1">
	<tr>
		<td>이름</td>
		<td>${detail.name}</td>
	</tr>
	<tr>
		<td>ID</td>
		<td>${detail.id}</td>
	</tr>
	<tr>
		<td>password</td>
		<td>${detail.password}</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${detail.age}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${detail.addr}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${detail.email}</td>
	</tr>
	<tr>
		<td>연락처</td>
		<td>${detail.phone}</td>
	</tr>
</table> --%>


<!-- 수정하기 구현 -->
<!-- <form action="modify" method="post"> --> <!-- 메소드 방식 언급안했으니까 get인데, id 보안위해 post로 해줘야함  -->
<form method="post">
<table border="1">
	<tr>
		<td>이름</td>
		<td>
			<input type="text" value="${detail.name}" name="name"/> <!-- 받아올 데이터를 input태그의 value값으로 지정 -->
		</td>
	</tr>
	<tr>
		<td>ID</td> <!-- 아이디는 입력안되게 해줘야함. --> <!-- 방법2가지 . read only처리해주거나, 두개 만들어서 DB로 보내줄 하나는 hidden처리해주기 -->
		<td>${detail.id}<input type="hidden" value="${detail.id}" name="id" /></td><!-- td태그에는 name속성이 없어서 어쩔수없이 input으로 해야함 -->
	</tr>
	<tr>
		<td>password</td>
		<td>
			<input type="password" value="${detail.password}" name="password"/>
		</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${detail.age}</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>${detail.addr}</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>${detail.email}</td>
	</tr>
	<tr>
		<td>연락처</td>
		<td>
			<input type="text" value="${detail.phone}" name="phone"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="수정" formaction="modify"> <!-- form태그의 액션은 지워야 함(우선권을 가지고 있어서..) -->
			<input type="submit" value="삭제" formaction="remove">
		</td>
	</tr>

</table>
</form>
</body>
</html>