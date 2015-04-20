package controller;

import java.util.List;

import model.Actor;
import model.Director;
import model.Genre;
import model.Movie;
import model.ScoreActor;
import model.ScoreDirector;
import model.Tag;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import dao.ActorDAO;
import dao.DirectorDAO;
import dao.GenreDAO;
import dao.MovieDAO;
import dao.TagDAO;

@Controller
@RequestMapping("/")
public class IndexController{
	
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
	
	private static final int LIMIT = 20;

	@RequestMapping("")
	protected ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<Movie> movies = movieDAO.getMoviesScore(LIMIT);
		List<ScoreActor> actors = actorDAO.getScoreActors(LIMIT);
		List<ScoreDirector> directors = directorDAO.getScoreDirectors(LIMIT);
		mv.addObject("limit", LIMIT);
		mv.addObject("movies", movies);
		mv.addObject("actors", actors);
		mv.addObject("directors", directors);
		return mv;
	}
	
	@RequestMapping("/search")
	protected ModelAndView search(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("search");
		List<Movie> movies = movieDAO.getMoviesLike(query);
		List<Actor> actors = actorDAO.getActorsLike(query);
		List<Director> directors = directorDAO.getDirectorsLike(query);
		List<Tag> tags = tagDAO.getTagsLike(query);
		List<Genre> genres = genreDAO.getGenresLike(query);
		
		List<Movie> exactMovie = movieDAO.getMovieByTitle(query);
		List<Actor> exactActor = actorDAO.getActorByName(query);
		List<Director> exactDirector = directorDAO.getDirectorByName(query);
		
		if(!exactMovie.isEmpty()) mv.addObject("exactMovie", exactMovie.get(0));
		if(!exactActor.isEmpty()) mv.addObject("exactActor", exactActor.get(0));
		if(!exactDirector.isEmpty()) mv.addObject("exactDirector", exactDirector.get(0));
		
		mv.addObject("movieCount", movies.size());
		mv.addObject("actorCount", actors.size());
		mv.addObject("directorCount", directors.size());
		mv.addObject("tagCount", tags.size());
		mv.addObject("genreCount", genres.size());
		
		
		mv.addObject("movies", movies.subList(0, (LIMIT > movies.size()) ? movies.size() : LIMIT));
		mv.addObject("actors", actors.subList(0, (LIMIT > actors.size()) ? actors.size() : LIMIT));
		mv.addObject("directors", directors.subList(0, (LIMIT > directors.size()) ? directors.size() : LIMIT));
		mv.addObject("tags", tags.subList(0, (LIMIT > tags.size()) ? tags.size() : LIMIT));
		mv.addObject("genres", genres);
		
		mv.addObject("query", query);
		mv.addObject("limit", LIMIT);
		
		return mv;
	}
	
}
