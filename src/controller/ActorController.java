package controller;

import java.util.List;

import model.Actor;
import model.Movie;
import model.ScoreActor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private static final int LIMIT = 25;

	@RequestMapping("")
	public ModelAndView actors(){
		ModelAndView mv = new ModelAndView("actors");
		List<Actor> actors = actorDAO.getActors(LIMIT);
		mv.addObject("pageNum", 0);
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
	
	@RequestMapping("/search")
	public ModelAndView actorsSearch(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView("actorsSearch");
		List<Actor> actors = actorDAO.getActorsLike(name, LIMIT);
		List<Actor> exact = actorDAO.getActorByName(name);
		if(!exact.isEmpty()){
			mv.addObject("exactActor", exact.get(0));
		}
		mv.addObject("pageNum", 0);
		mv.addObject("searchName", name);
		mv.addObject("actors", actors);
		return mv;
	}
	
	@RequestMapping("/search/page/{pageNum}")
	public ModelAndView actorsSearchPage(@PathVariable int pageNum, @RequestParam("name") String name){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("actorsSearch");
		List<Actor> actors = actorDAO.getActorsLike(name, LIMIT, offset);
		List<Actor> exact = actorDAO.getActorByName(name);
		if(!exact.isEmpty()){
			mv.addObject("exactActor", exact.get(0));
		}
		mv.addObject("pageNum", pageNum);
		mv.addObject("searchName", name);
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
