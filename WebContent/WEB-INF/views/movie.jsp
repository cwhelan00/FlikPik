<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${movie.title}</title>
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
				<li><a href="<c:url value="/" />">Home</a></li>
				<li><a href="<c:url value="/movies" />">Movies</a></li>
				<li><a href="<c:url value="/actors" />">Actors</a></li>
				<li><a href="<c:url value="/directors" />">Directors</a></li>
			</ul>
			
			<form class="navbar-form navbar-right" method="get" action="<c:url value="/search" />" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search" name="query" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>
	
	<br />
	<br />

	<div class="container">
		<h2>${movie.title}</h2>
		<div class="col-xs-12 panel panel-default">
			<div class="col-xs-6">
				<img src="${movie.rtPictureUrl}" />
				<img src="${movie.imdbPictureUrl}" />
				<br />
			</div>
			<div class="col-xs-6">
				<p>Title: ${movie.title}</p>
				<p>Directed By: <a href="<c:url value="/directors/director/${director.id}" />">${director.name}</a></p>
				<p>Year: ${movie.year}</p>
				<p>Score: ${movie.rtAudienceScore}</p>
			</div>
		</div>
		
		<div class="row">
			<div class="panel panel-default col-xs-3">
				<h2>Actors</h2>
				<ul>
					<c:forEach var="actor" items="${actors}">
					<li><a href="<c:url value="/actors/actor/${actor.id}" />" class="actor" >${actor.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="panel panel-default col-xs-3 col-xs-offset-1">
				<h2>Genres</h2>
				<ul>
					<c:forEach var="genre" items="${genres}">
					<li><a href="<c:url value="/movies/genre/${genre.type}" />">${genre.type}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="panel panel-default col-xs-3 col-xs-offset-1">
				<h2>Tags</h2>
				<ul>
					<c:forEach var="tag" items="${tags}">
					<li><a href="<c:url value="/movies/tag/${tag.id}" />">${tag.value}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>