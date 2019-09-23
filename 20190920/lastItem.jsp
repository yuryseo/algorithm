<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.model.dto.Item, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마지막으로 등록한 상품</title>
</head>
<body>
	

	<c:if test="${msg !=null}">
		${msg}
	</c:if>

	<table align="center">
	<h1 align="center">마지막으로 등록한 상품</h1>
	<br/>
	<tr><td width="100">상품번호</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        <td width="100">상품명</td>
        <td width="100">상품가격</td>
        <td width="200">상품설명</td>
    </tr>
    	
    <br/>	
	<tr><td>${last.no}</td>
    	<td>${last.name}</td> 
    	<td>${last.price}</td> 
    	<td>${last.desc}</td> 
    </tr>

	</table>

</body>
</html>