<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${movie.title}</title>
</head>
<body>
	<p>title: ${movie.title}</p>
	<p>year: ${movie.year}</p>
	<p>score: ${movie.rtAudienceScore}</p>
	<p>director: <a href="<c:url value="/directors/director/${director.id}" />">${director.name}</a></p>
	<img src="${movie.rtPictureUrl}"></img>
	<img src="${movie.imdbPictureUrl}"></img>
	<p>Check these actors:</p>
	<ul>
		<c:forEach var="actor" items="${actors}">
		<li><a href="<c:url value="/actors/actor/${actor.id}" />">${actor.name}</a></li>
		</c:forEach>
	</ul>
	<p>How bout them genres</p>
	<ul>
		<c:forEach var="genre" items="${genres}">
		<li><a href="<c:url value="/movies/genre/${genre.type}" />">${genre.type}</a></li>
		</c:forEach>
	</ul>
	<p>Or all the tags</p>
	<ul>
		<c:forEach var="tag" items="${tags}">
		<li><a href="<c:url value="/movies/tag/${tag.id}" />">${tag.value}</a></li>
		</c:forEach>
	</ul>
</body>
</html>