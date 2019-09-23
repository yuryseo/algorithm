<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body align="center">
<h1>메인 페이지</h1>
<c:choose>

	<c:when test="${id!=null }">
	<h2>${sessionScope.id}님 환영합니다.<a href = "logout.do"> 로그아웃 </a></h2>
		<a href="InsertItem.html">상품 등록</a>
		<a href="DeleteItem.html">상품 삭제</a>
		<a href="itemlist.do">상품 목록</a>
		<br/>
		<a href="itemlast.do">마지막 등록한 상품</a>

	</c:when>
	<c:otherwise>
	<h2> 로그인하여 주세요 </h2>
<form method="post"  action="login.do">
	<table align="center" border="1">
		<tr><td>아 이 디</td>
		<td><input type="text" name="id" value=""></td></tr>
		<tr><td>비밀번호</td>
		<td><input type="password" name="password"></td></tr>
		
	</table>
	<br/>
		<input type="submit" value="로그인">
</form>
	</c:otherwise>

</c:choose>

</body>
</html>