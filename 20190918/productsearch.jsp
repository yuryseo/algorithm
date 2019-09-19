<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품</title>
</head>
<body>
<%
String productnum =  (String)request.getAttribute("productnum");
String price =  (String)request.getAttribute("price");
String description =  (String)request.getAttribute("description");
%>
<form method="post" >

<table>
	<tr><td class="caption" colspan='2'>상품정보</td></tr>
	<tr><td class='tbasic'>상품 번호</td>
	    <td class='tbasic'>
	    <input type='text' name='num'  id='num' value='1'></td>
	</tr>
	<tr><td class='tbasic'>상 품 명</td>
	    <td class='tbasic'><input type='text' name='productnum'  id='productnum' value='<%=productnum%>'></td>
	</tr>
	<tr><td class='tbasic'>상품 가격</td>
	    <td class='tbasic'><input type='text' name='price'  id='price' value='<%=price%>' ></td>
	</tr>
	<tr><td class='tbasic'>상품 설명</td>
	    <td class='tbasic'><input type='text' name='description'  id='description'  value='<%=description%>'>
	</tr>

</table>

</form>




</body>
</html>