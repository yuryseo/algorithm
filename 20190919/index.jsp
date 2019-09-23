<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type='text/javascript' src='./js/jquery-3.4.1.js'></script>
<script type="text/javascript">
$(function() {
	$('button[type="submit"]').click(function() {
		if($('input').val() == "") {
			alert("아이디와 비밀번호를 모두 입력해주세요!")
		}
	})
})
</script>
</head>
<body align="center">
<h1>메인 페이지</h1>
<%
	String loginId = (String)session.getAttribute("id");
	if(loginId != null) { // 인증 된 경우 %>
		<h3><%=loginId %> 님 환영합니다. <a href = "logout.do"> 로그아웃 </a></h3>
		<a href="InsertItem.html">상품 등록</a>
		<a href="itemlist.do">상품 목록</a>
		<a href="itemlast.do">마지막 등록한 상품</a>
<%	} else {	%>
		<h3>로그인하여 주세요</h3>
<% 
		String msg = (String)request.getAttribute("msg");
		Cookie[] cookies = request.getCookies();
		String id="";
		String checked="";
		if(cookies!=null){
			for(Cookie cookie: cookies){
				if(cookie.getName().equals("id")){
					id = cookie.getValue();
				}
			}
		}
%>
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
<% } %>
</body>
</html>