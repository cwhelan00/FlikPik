/**
 * 
 */

var movies = document.getElementsByClassName('movie');
var image = document.getElementById('movieImg');
image.style.visibility = 'hidden';

for(var i = 0; i < movies.length; i++){
	movies[i].onmouseover = showImage;
	movies[i].onmouseleave = removeImage;
}
	

function showImage(){
	image.setAttribute('src', this.getAttribute('url'));
	image.style.visibility = 'visible';
}

function removeImage(){
	image.style.visibility = 'hidden';
}