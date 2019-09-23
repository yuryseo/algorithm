<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.model.dto.Item, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 화면</title>
</head>
<body>
<%
String msg = (String) request.getAttribute("msg");
List<Item> item = (List) request.getAttribute("item");
if(msg != null) {
%>	<%=msg%>
<%	} else if (item != null){ %>
<table align="center">
	<tr><td width="100">상품번호</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        <td width="100">상품명</td>
        <td width="100">상품가격</td>
        <td width="200">상품설명</td>
    </tr>
    <br/>
    <% int index = 0; %>
<%	for (Item it: item) { %>
    <tr><td><%= it.getNo() %></td>
    	<td><%= it.getName() %></td> 
    	<td><%= it.getPrice() %></td> 
    	<td><%= it.getDesc() %></td> 
    </tr>
<% } %>
</table>
<% } else {%>
   장바구니가 비었습니다.
<% } %>
</body>
</html>