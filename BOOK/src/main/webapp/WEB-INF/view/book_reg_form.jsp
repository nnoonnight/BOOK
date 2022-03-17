<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 추가</title>
</head>
<body>
<form:form commandName="regForm" action="${pageContext.request.contextPath}/books/add" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th rowspan="5"><input type="file" name="img"></th><th>ISBN</th><td><form:input path="isbn" pattern="[0-9]+" placeholder="숫자만 입력"/><form:errors path="isbn" /></td>
		</tr>
		<tr>
			<th>도서명</th><td><form:input path="title" /><form:errors path="title" /></td>
		</tr>
		<tr>
			<th>저자</th><td><form:input path="author"/><form:errors path="author" /></td>
		</tr>
		<tr>
			<th>출판사</th><td><form:input path="publisher"/><form:errors path="publisher" /></td>
		</tr>
		<tr>
			<th>도서 가격</th><td><form:input path="price"/><form:errors path="price" pattern="[0-9]+" placeholder="숫자만 입력"/></td>
		</tr>
		<tr>
			<th>책소개</th><td colspan="2"><form:input path="intro"/><form:errors path="intro" /></td>
		</tr>
	</table>
	<input type="submit" value="도서 등록">	
</form:form>
		<a href="<c:url value="/books/list"/>">도서 목록</a>
</body>
</html>