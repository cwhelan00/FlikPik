package controller;

import java.util.List;

import model.Actor;
import model.Movie;
import model.ScoreActor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ActorDAO;
import dao.MovieDAO;

@Controller
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	ActorDAO actorDAO;
	
	@Autowired
	MovieDAO movieDAO;
	
	private static final int LIMIT = 50;

	@RequestMapping("")
	public ModelAndView actors(){
		ModelAndView mv = new ModelAndView("actors");
		List<Actor> actors = actorDAO.getActors();
		mv.addObject("actors", actors);
		return mv;
	}
	
	@RequestMapping("/page/{pageNum}")
	public ModelAndView actorsPage(@PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("actors");
		List<Actor> actors = actorDAO.getActors(LIMIT, offset);
		mv.addObject("actors", actors);
		return mv;
	}
	
	@RequestMapping("/actor/{actorID}")
	public ModelAndView getActor(@PathVariable String actorID){
		ModelAndView mv = new ModelAndView("actor");
		ScoreActor actor = actorDAO.getScoreActor(actorID);
		List<Movie> movies = movieDAO.getMoviesByActor(actorID);
		mv.addObject("actor", actor);
		mv.addObject("movies", movies);
		return mv;
	}
}
