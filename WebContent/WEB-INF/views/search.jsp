<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search</title>
	<link href="http://fonts.googleapis.com/css?family=Lobster+Two" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>

	<nav class="nav navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Flik Pik</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="#">Home</a></li>
				<li><a href="<c:url value="/movies" />">Movies</a></li>
				<li><a href="<c:url value="/actors" />">Actors</a></li>
				<li><a href="<c:url value="/diretors" />">Directors</a></li>
			</ul>
			
			<form class="navbar-form navbar-right" method="get" action="<c:url value="/search" />" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" name="query" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>
	
	<h2>There were</h2>
	<div class="container">
		<div class="col-xs-6">
			<p><strong>${movieCount}</strong> results for movies</p>
			<p><strong>${actorCount}</strong> results for actors</p>
			<p><strong>${directorCount}</strong> results for directors</p>
		</div>
		<div class="col-xs-6">
			<div id="movies" class="panel panel-default">
				<p>Movies:</p>
				<c:forEach var="movie" items="${movies}">
				<li><a href="<c:url value="/movies/movie/${movie.id}" />">${movie.title}</a></li>
				</c:forEach>
			</div>
			
			<div id="actors" class="panel panel-default">
				<p>Actors:</p>
				<c:forEach var="actor" items="${actors}">
				<li><a href="<c:url value="/actors/actor/${actor.id}" />">${actor.name}</a></li>
				</c:forEach>
			</div>
			
			<div id="directors" class="panel panel-default">
				<p>Directors:</p>
				<c:forEach var="director" items="${directors}">
				<li><a href="<c:url value="/directors/director/${director.id}" />">${director.name}</a></li>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>