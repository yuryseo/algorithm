<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.model.dto.Item, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
<%
String msg = (String) request.getAttribute("msg");
Item item = (Item) request.getAttribute("last");
if(msg != null) {
%>	<%=msg%>
<%	} else if (item != null){ %>

<h1 align="center">마지막 등록한 상품</h1><br/>
<table align="center">
	<tr><td width="100">상품번호</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        <td width="100">상품명</td>
        <td width="100">상품가격</td>
        <td width="200">상품설명</td>
    </tr>

    <tr><td><%= item.getNo() %></td>
    	<td><%= item.getName() %></td> 
    	<td><%= item.getPrice() %></td> 
    	<td><%= item.getDesc() %></td> 
    </tr>
</table>
<% } else {%>
   등록한 상품이 없습니다.
<% } %>
</body>
</html>