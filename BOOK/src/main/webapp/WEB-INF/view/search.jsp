<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
</head>
<body>

'${searchCommand.searchWord }' 로  
<c:if test="${searchCommand.searchOption eq 'title' }">
	제목
</c:if>
<c:if test="${searchCommand.searchOption eq 'author' }">
	저자
</c:if>
<c:if test="${searchCommand.searchOption eq 'publisher' }">
	출판사
</c:if>
 검색 결과
<br><br>
	<table border="1">
		<tr>
			<th>등록번호</th><th>도서표지</th><th>ISBN</th><th>제목</th><th>저자</th><th>출판사</th><th>가격</th>
		</tr>
	<c:if test="${empty bookList }">
		<tr>
			<th colspan="7"> 등록된 도서가 없습니다</th>
		</tr>
	</c:if>
	<c:if test="${!empty bookList }">
		<c:forEach var="book" items="${bookList }" varStatus="loop">	
		<tr>
			<td>${book.num}</td>
			<td><img src="<spring:url value='/resources/upload/${book.name }'/>" width="100" ></td>
			<td>${book.isbn}</td>
			<td><a href="<c:url value="/books/read/${book.num }"/>">${book.title}</a></td>
			<td>${book.author}</td>
			<td>${book.publisher}</td>
			<td>${book.price}</td>
		</tr>		
		</c:forEach>
	</table>
	</c:if>

	<a href="<c:url value="/books/list"/>">도서 목록</a>
</body>
</html>