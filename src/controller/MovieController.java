package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.ActorDAO;
import dao.DirectorDAO;
import dao.GenreDAO;
import dao.MovieDAO;
import dao.TagDAO;
import model.Actor;
import model.Director;
import model.Genre;
import model.Movie;
import model.Tag;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private ActorDAO actorDAO;
	
	@Autowired
	private DirectorDAO directorDAO;
	
	@Autowired
	private GenreDAO genreDAO;
	
	@Autowired
	private TagDAO tagDAO;
	
	private static final int LIMIT = 25;
	
	@RequestMapping("")
	public ModelAndView movies(){
		ModelAndView mv = new ModelAndView("movies");
		List<Movie> movies = movieDAO.getMovies(LIMIT);
		mv.addObject("pageNum", 0);
		mv.addObject("movies", movies);
		mv.addObject("selected", "all");
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView moviesSearch(@RequestParam("title") String title){
		ModelAndView mv = new ModelAndView("moviesSearch");
		List<Movie> movies = movieDAO.getMoviesLike(title, LIMIT);
		List<Movie> exact = movieDAO.getMovieByTitle(title);
		if(!exact.isEmpty()){
			mv.addObject("exactMovie", exact.get(0));
		}
		mv.addObject("pageNum", 0);
		mv.addObject("searchTitle", title);
		mv.addObject("movies", movies);
		mv.addObject("selected", "all");
		return mv;
	}
	
	@RequestMapping("/search/page/{pageNum}")
	public ModelAndView moviesSearchPage(@PathVariable int pageNum, @RequestParam("title") String title){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("moviesSearch");
		List<Movie> movies = movieDAO.getMoviesLike(title, LIMIT, offset);
		List<Movie> exact = movieDAO.getMovieByTitle(title);
		if(!exact.isEmpty()){
			mv.addObject("exactMovie", exact.get(0));
		}
		mv.addObject("pageNum", pageNum);
		mv.addObject("searchTitle", title);
		mv.addObject("movies", movies);
		mv.addObject("selected", "all");
		return mv;
	}
	
	@RequestMapping("/page/{pageNum}")
	public ModelAndView moviesPage(@PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("movies");
		List<Movie> movies = movieDAO.getMovies(LIMIT, offset);
		mv.addObject("pageNum", pageNum);
		mv.addObject("movies", movies);
		mv.addObject("genreType", "all");
		return mv;
	}
	
	@RequestMapping("/genre/{genreType}")
	public ModelAndView getMoviesByGenre(@PathVariable String genreType){
		ModelAndView mv = new ModelAndView("moviesGenre");
		List<Movie> movies = movieDAO.getMoviesByGenre(genreType, LIMIT);
		mv.addObject("pageNum", 0);
		mv.addObject("movies", movies);
		mv.addObject("genreType", genreType);
		return mv;
	}
	
	@RequestMapping("/genre/{genreType}/page/{pageNum}")
	public ModelAndView getMoviesByGenrePage(@PathVariable String genreType, @PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("moviesGenre");
		List<Movie> movies = movieDAO.getMoviesByGenre(genreType, LIMIT, offset);
		mv.addObject("pageNum", pageNum);
		mv.addObject("movies", movies);
		mv.addObject("selected", genreType);
		return mv;
	}
	
	@RequestMapping("/tag/{tagID}")
	public ModelAndView getMoviesByTag(@PathVariable int tagID){
		ModelAndView mv = new ModelAndView("moviesTag");
		List<Movie> movies = movieDAO.getMoviesByTag(tagID, LIMIT);
		Tag tag = tagDAO.getTag(tagID);
		mv.addObject("tagValue", tag.getValue());
		mv.addObject("pageNum", 0);
		mv.addObject("tagID", tagID);
		mv.addObject("movies", movies);
		return mv;
	}
	
	@RequestMapping("/tag/{tagID}/page/{pageNum}")
	public ModelAndView getMoviesByTagPage(@PathVariable int tagID, @PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("moviesTag");
		List<Movie> movies = movieDAO.getMoviesByTag(tagID, LIMIT, offset);
		Tag tag = tagDAO.getTag(tagID);
		mv.addObject("pageNum", pageNum);
		mv.addObject("tagID", tagID);
		mv.addObject("tagValue", tag.getValue());
		mv.addObject("movies", movies);
		return mv;
	}
	
	@RequestMapping("/tag/search")
	public ModelAndView getMoviesByTagSearch(@RequestParam("value") String value){
		ModelAndView mv = new ModelAndView("moviesTagSearch");
		List<Movie> movies = movieDAO.getMoviesByTagLike(value, LIMIT);
		mv.addObject("pageNum", 0);
		mv.addObject("tagValue", value);
		mv.addObject("movies", movies);
		return mv;
	}
	
	@RequestMapping("/tag/search/page/{pageNum}")
	public ModelAndView getMoviesByTagSearch(@RequestParam("value") String value, @PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("moviesTagSearch");
		List<Movie> movies = movieDAO.getMoviesByTagLike(value, LIMIT, offset);
		mv.addObject("pageNum", pageNum);
		mv.addObject("tagValue", value);
		mv.addObject("movies", movies);
		return mv;
	}
	
	@RequestMapping("/movie/{movieID}")
	public ModelAndView getMovie(@PathVariable int movieID){
		ModelAndView mv = new ModelAndView("movie");
		Movie movie = movieDAO.getMovie(movieID);
		if(movie.getDirectorId() != null){
			Director director = directorDAO.getDirectorByMovie(movieID);
			mv.addObject("director", director);
		}
		List<Actor> actors = actorDAO.getActorsByMovie(movieID);
		List<Genre> genres = genreDAO.getGenreByMovie(movieID);
		List<Tag> tags = tagDAO.getTagsByMovie(movieID);
		mv.addObject("movie", movie);
		
		mv.addObject("actors", actors);
		mv.addObject("genres", genres);
		mv.addObject("tags", tags);
		return mv;
	}
}
