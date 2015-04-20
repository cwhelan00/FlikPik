<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/FlikPik/tags/search">
		<input name="value" />
		<input type="submit" value="search" />
	</form>
	<p>page number: ${pageNum}</p>

	<ul>
		<c:forEach var="tag" items="${tags}">
		<li><a href="<c:url value="/movies/tag/${tag.id}" />">${tag.value}</a></li>
		</c:forEach>
	</ul>
	
	<p>pagination:</p>
	<ul>
		<c:if test="${pageNum > 0}">
		<li><a href="<c:url value="/tags/page/${pageNum - 1}" />">previous</a></li>
		</c:if>
		<li><a href="<c:url value="/tags/page/${pageNum + 1}" />">next</a></li>
	</ul>
</body>
</html>