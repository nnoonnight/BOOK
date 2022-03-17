<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
	<table border="1">
		<tr>
			<th rowspan="5"><img src="<spring:url value='/resources/upload/${bookDetail.name }'/>" width="200" ></th><th>ISBN</th><td>${bookDetail.isbn }</td>
		</tr>
		<tr>
			<th>도서명</th><td>${bookDetail.title }</td>
		</tr>
		<tr>
			<th>저자</th><td>${bookDetail.author }</td>
		</tr>
		<tr>
			<th>출판사</th><td>${bookDetail.publisher }</td>
		</tr>
		<tr>
			<th>도서 가격</th><td>${bookDetail.price }</td>
		</tr>
		<tr>
			<th>책소개</th><td colspan="2">${bookDetail.intro }</td>
		</tr>
	</table>
		<a href="<c:url value="/books/list"/>">도서 목록</a>
</body>
</html>