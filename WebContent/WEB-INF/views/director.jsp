<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${director.name}</title>
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
		<h2>Director</h2>
	
		<div class="col-xs-12 panel panel-default">
			<p class="large">${director.name}</p>
			<p>Average Movie Score: ${director.avgScore}</p>
		</div>
		<div class="row">
			<div class="panel panel-default col-xs-6">
				<h2>Movies</h2>
				<ul>
					<c:forEach var="movie" items="${movies}">
					<li><a href="<c:url value="/movies/movie/${movie.id}" />" class="movie" url="${movie.rtPictureUrl}">${movie.title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-xs-6">
				<img id="movieImg" style="height: 500px; width: 400px;" src="" />
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/js/movieOver.js" />"></script>
</body>
</html>