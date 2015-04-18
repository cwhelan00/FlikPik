package controller;

import java.util.List;

import model.Movie;
import model.ScoreActor;
import model.ScoreDirector;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import dao.ActorDAO;
import dao.DirectorDAO;
import dao.MovieDAO;

@Controller
@RequestMapping("/")
public class IndexController{
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private ActorDAO actorDAO;
	
	@Autowired
	private DirectorDAO directorDAO;
	
	private static final int LIMIT = 20;

	@RequestMapping("")
	protected ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<Movie> movies = movieDAO.getMovies(LIMIT);
		List<ScoreActor> actors = actorDAO.getScoreActors(LIMIT);
		List<ScoreDirector> directors = directorDAO.getScoreDirectors(LIMIT);
		mv.addObject("limit", LIMIT);
		mv.addObject("movies", movies);
		mv.addObject("actors", actors);
		mv.addObject("directors", directors);
		return mv;
	}
	
}
