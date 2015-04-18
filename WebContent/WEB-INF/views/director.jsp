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
	<p>name: ${director.name}</p>
	<p>average movie score: ${director.avgScore}</p>
	<p>Check out these movies I made</p>
	
	<ul>
		<c:forEach var="movie" items="${movies}">
		<li><a href="<c:url value="/movies/movie/${movie.id}" />">${movie.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>