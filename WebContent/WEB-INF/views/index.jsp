<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pik Them Fliks</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
</head>
<body>
	<h2>Here be Fliks</h2>
	
	<p>Top ${limit} movies</p>
	<ul>
		<c:forEach var="movie" items="${movies}">
		<li>${movie.title}</li>
		</c:forEach>
	</ul>
	<p>Top ${limit} actors</p>
	<ul>
		<c:forEach var="actor" items="${actors}">
		<li>${actor.name}</li>
		</c:forEach>
	</ul>
	<p>Top ${limit} directors</p>
	<ul>
		<c:forEach var="director" items="${directors}">
		<li>${director.name}</li>
		</c:forEach>
	</ul>
</body>
</html>