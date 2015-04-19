package controller;

import java.util.List;

import model.Actor;
import model.Director;
import model.Movie;
import model.ScoreDirector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.DirectorDAO;
import dao.MovieDAO;

@Controller
@RequestMapping("/directors")
public class DirectorController {

	@Autowired
	DirectorDAO directorDAO;
	
	@Autowired
	MovieDAO movieDAO;
	
	private static final int LIMIT = 50;
	
	@RequestMapping("")
	public ModelAndView directors(){
		ModelAndView mv = new ModelAndView("directors");
		List<Director> directors = directorDAO.getDirectors(LIMIT);
		mv.addObject("pageNum", 0);
		mv.addObject("directors", directors);
		return mv;
	}
	
	@RequestMapping("/page/{pageNum}")
	public ModelAndView actorsPage(@PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("directors");
		List<Director> directors = directorDAO.getDirectors(LIMIT, offset);
		mv.addObject("pageNum", pageNum);
		mv.addObject("directors", directors);
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView directorsSearch(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView("directorsSearch");
		List<Director> directors = directorDAO.getDirectorsLike(name, LIMIT);
		List<Director> exact = directorDAO.getDirectorByName(name);
		if(!exact.isEmpty()){
			mv.addObject("exactDirector", exact.get(0));
		}
		mv.addObject("pageNum", 0);
		mv.addObject("searchName", name);
		mv.addObject("directors", directors);
		return mv;
	}
	
	@RequestMapping("/search/page/{pageNum}")
	public ModelAndView directorsSearchPage(@PathVariable int pageNum, @RequestParam("name") String name){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("directorsSearch");
		List<Director> directors = directorDAO.getDirectorsLike(name, LIMIT, offset);
		List<Director> exact = directorDAO.getDirectorByName(name);
		if(!exact.isEmpty()){
			mv.addObject("exactDirector", exact.get(0));
		}
		mv.addObject("pageNum", pageNum);
		mv.addObject("searchName", name);
		mv.addObject("directors", directors);
		return mv;
	}
	
	@RequestMapping("/director/{directorID}")
	public ModelAndView getDirector(@PathVariable String directorID){
		ModelAndView mv = new ModelAndView("director");
		ScoreDirector director = directorDAO.getScoreDirector(directorID);
		List<Movie> movies = movieDAO.getMoviesByDirector(directorID);
		mv.addObject("director", director);
		mv.addObject("movies", movies);
		return mv;
	}
}
