<%@page import="com.ssafy.model.dto.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.dto.Item"%>
<%!  //선언부:  속성이나 메서드를 선언할 수 있다.  
    private int index = 0;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
	Item item = (Item)request.getAttribute("item");
	if(msg != null) {
%>	<%=msg%>
<%	} else { %>
<form method="get" action="iteminsert.do">
<h1>상품이 저장되었습니다.</h1>
<table>
	<tr><td class='tbasic'>상품번호: </td>
	    <td class='tbasic'><%=++index%></td>
	</tr>
	<tr><td class='tbasic'>상품명: </td>
	    <td class='tbasic'><%=item.getName()%></td>
	</tr>
	<tr><td class='tbasic'>상품가격: </td>
	    <td class='tbasic'><%=item.getPrice()%></td>
	</tr>
	<tr><td class='tbasic'>상품설명: </td>
	    <td class='tbasic'><%=item.getDesc()%></td>
	</tr>
</table>
</form>
<% } %>
</body>
</html>