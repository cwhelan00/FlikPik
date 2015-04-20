/**
 * 
 */

var movies = document.getElementById('movies');
var actors = document.getElementById('actors');
var directors = document.getElementById('directors');
var tags = document.getElementById('tags');
var genres = document.getElementById('genres');

var movieCount = document.getElementById('movieCount');
var actorCount = document.getElementById('actorCount');
var directorCount = document.getElementById('directorCount');
var tagCount = document.getElementById('tagCount');
var genreCount = document.getElementById('genreCount');

var current = undefined;

movies.style.display = 'none';
actors.style.display = 'none';
directors.style.display = 'none';
tags.style.display = 'none';
genres.style.display = 'none';

movieCount.onclick = showMovies;
actorCount.onclick = showActors;
directorCount.onclick = showDirectors;
tagCount.onclick = showTags;
genreCount.onclick = showGenres;


function showMovies(){
	if(current) current.style.display = 'none';
	movies.style.display = 'block';
	current = movies;
}

function showActors(){
	if(current) current.style.display = 'none';
	actors.style.display = 'block';
	current = actors;
}

function showDirectors(){
	if(current) current.style.display = 'none';
	directors.style.display = 'block';
	current = directors;
}

function showTags(){
	if(current) current.style.display = 'none';
	tags.style.display = 'block';
	current = tags;
}

function showGenres(){
	if(current) current.style.display = 'none';
	genres.style.display = 'block';
	current = genres;
}

