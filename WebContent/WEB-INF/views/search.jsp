<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
		<div>
			<c:if test="${not empty exactMovie}">
			<h2>Your Query Exactly Matched This Movie</h2>
			<div id="exactMovie" class="col-xs-12 panel panel-default clickable">
				<div class="col-xs-6">
					<a href="<c:url value="/movies/movie/${exactMovie.id}" />"><img id="exactMovieImg" src="${exactMovie.rtPictureUrl}" /></a>
					<br />
				</div>
				<div class="col-xs-6">
					<p>Title: ${exactMovie.title}</p>
					<p>Year: ${exactMovie.year}</p>
					<p>Score: ${exactMovie.rtAudienceScore}</p>
				</div>
			</div>
			<hr />
			</c:if>
			<c:if test="${not empty exactActor}">
			<h2>Your Query Exactly Matched This Actor</h2>
			<div class="col-xs-12 panel panel-default">
				<p class="large"><a href="<c:url value="/actors/actor/${exactActor.id}" />">${exactActor.name}</a></p>
			</div>
			<hr />
			</c:if>
			<c:if test="${not empty exactDirector}">
			<h2>Your Query Exactly Matched This Director</h2>
			<div class="col-xs-12 panel panel-default">
				<p class="large"><a href="<c:url value="/directors/director/${exactDirector.id}" />">${exactDirector.name}</a></p>
			</div>
			<hr />
			</c:if>
		</div>
		<div class="col-xs-6">
			<div id="movieCount" class="panel panel-default clickable">
				<p><strong class="large">${movieCount}</strong> results for movies</p>
			</div>
			<div id="actorCount" class="panel panel-default clickable">
				<p><strong class="large">${actorCount}</strong> results for actors</p>
			</div>
			<div id="directorCount" class="panel panel-default clickable">
				<p><strong class="large">${directorCount}</strong> results for directors</p>
			</div>
			<div id="tagCount" class="panel panel-default clickable">
				<p><strong class="large">${tagCount}</strong> results for tags</p>
			</div>
			<div id="genreCount" class="panel panel-default clickable">
				<p><strong class="large">${genreCount}</strong> results for genres</p>
			</div>
		</div>
		<div class="col-xs-6">
			<div id="movies" class="panel panel-default">
				<p>Movies:</p>
				<c:forEach var="movie" items="${movies}">
				<li><a href="<c:url value="/movies/movie/${movie.id}" />">${movie.title}</a></li>
				</c:forEach>
				<hr />
				<p><a href="<c:url value="/movies/search/page/0?title=${query}" />">See More Results</a></p>
			</div>
			
			<div id="actors" class="panel panel-default">
				<p>Actors:</p>
				<c:forEach var="actor" items="${actors}">
				<li><a href="<c:url value="/actors/actor/${actor.id}" />">${actor.name}</a></li>
				</c:forEach>
				<hr />
				<p><a href="<c:url value="/actors/search/page/0?name=${query}" />">See More Results</a></p>
			</div>
			
			<div id="directors" class="panel panel-default">
				<p>Directors:</p>
				<c:forEach var="director" items="${directors}">
				<li><a href="<c:url value="/directors/director/${director.id}" />">${director.name}</a></li>
				</c:forEach>
				<hr />
				<p><a href="<c:url value="/directors/search/page/0?name=${query}" />">See More Results</a></p>
			</div>
			
			<div id="tags" class="panel panel-default">
				<p>Tags:</p>
				<c:forEach var="tag" items="${tags}">
				<li><a href="<c:url value="/movies/tag/${tag.id}" />">${tag.value}</a></li>
				</c:forEach>
				<hr />
				<p><a href="<c:url value="/tags/search/page/0?value=${query}" />">See More Results</a></p>
			</div>
			
			<div id="genres" class="panel panel-default">
				<p>Genres:</p>
				<c:forEach var="genre" items="${genres}">
				<li><a href="<c:url value="/movies/genre/${genre.type}" />">${genre.type}</a></li>
				</c:forEach>
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/js/searchSelect.js" />"></script>
	<script src="<c:url value="/resources/js/exactMovie.js" />"></script>
</body>
</html>