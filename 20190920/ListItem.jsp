<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.model.dto.Item, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<form method="get" action="searchprice.do">
		<table align="center">
			<tr>
				<td class='tbasic'>검색 할 가격 입력 : <input type="text" name='price'
					id='price'>
				</td>

				<td colspan='2' class='tfoot tspacial'><input type="submit"
					value='검색'> <input type="reset" value='취소'></td>
			</tr>
		</table>

	</form>

	<c:if test="${msg!=null}">
		<tr><td colspan="2" class ='errormsg'>${msg}</td></tr>
	</c:if>
	<table align="center">
	<tr><td width="100">상품번호</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
        <td width="100">상품명</td>
        <td width="100">상품가격</td>
        <td width="200">상품설명</td>
    </tr>
    <br/>	
		<br/>	
	<c:forEach items="${item}" var="i">
	 <tr><td>${i.no}</td>
    	<td>${i.name}</td> 
    	<td>${i.price}</td> 
    	<td>${i.desc}</td> 
    </tr>
	
	</c:forEach>
	
	</table>

</body>
</html>