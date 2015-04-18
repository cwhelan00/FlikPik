package controller;

import java.util.List;

import model.Director;
import model.Movie;
import model.ScoreDirector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("")
	public ModelAndView directors(){
		ModelAndView mv = new ModelAndView("directors");
		List<Director> directors = directorDAO.getDirectors();
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
