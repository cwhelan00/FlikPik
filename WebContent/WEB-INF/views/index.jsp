<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Flik Pik</title>
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
				<li class="active"><a href="#">Home</a></li>
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
	
	<div id="home-image" class="jumbotron">
	</div>
	
	<div class="container">
		<h2>Top ${limit}'s</h2>
		<hr />
		<div class="panel panel-default col-xs-3">
			<div>
				<h3>Movies</h3>
			</div>
			<div class="panel-body">
				<ul>
					<c:forEach var="movie" items="${movies}">
					<li><a href="<c:url value="/movies/movie/${movie.id}" />">${movie.title}</a></li>
					</c:forEach>
				</ul>
				<a href="<c:url value="/movies" />"><button class="btn btn-default pull-right">Movies</button></a>
			</div>
		</div>
		<div class="panel panel-default col-xs-3 col-xs-offset-1">
			<div>
				<h3>Actors</h3>
			</div>
			<div class="panel-body">
				<ul>
					<c:forEach var="actor" items="${actors}">
					<li><a href="<c:url value="/actors/actor/${actor.id}" />">${actor.name}</a></li>
					</c:forEach>
				</ul>
				<a href="<c:url value="/actors" />"><button class="btn btn-default pull-right">Actors</button></a>
			</div>
		</div>
		<div class="panel panel-default col-xs-3 col-xs-offset-1">
			<div>
				<h3>Directors</h3>
			</div>
			<div class="panel-body">
				<ul>
					<c:forEach var="director" items="${directors}">
					<li><a href="<c:url value="/directors/director/${director.id}" />">${director.name}</a></li>
					</c:forEach>
				</ul>
				<a href="<c:url value="/directors" />"><button class="btn btn-default pull-right">Directors</button></a>
			</div>
		</div>
	</div>
</body>
</html>