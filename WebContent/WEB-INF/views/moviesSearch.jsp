<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="/FlikPik/movies/search">
		<input name="title" value="${searchTitle}"/>
		<input type="submit" value="search" />
	</form>
	<p>page number: ${pageNum}</p>
	
	<c:if test="${not empty exactMovie}">
	<p>We found an exact match here</p>
	<p><a href="<c:url value="/movies/movie/${exactMovie.id}" />">${exactMovie.title}</a></p>
	</c:if>
	<ul>
		<c:forEach var="movie" items="${movies}">
		<li><a href="<c:url value="/movies/movie/${movie.id}" />">${movie.title}</a></li>
		</c:forEach>
	</ul>
	
	<p>pagination:</p>
	<ul>
		<c:if test="${pageNum > 0}">
		<li><a href="<c:url value="/movies/search/page/${pageNum - 1}?title=${searchTitle}" />">previous</a></li>
		</c:if>
		<li><a href="<c:url value="/movies/search/page/${pageNum + 1}?title=${searchTitle}" />">next</a></li>
	</ul>
</body>
</html>