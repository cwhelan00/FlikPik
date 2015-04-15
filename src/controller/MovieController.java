package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MovieDAO;
import model.Movie;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieDAO movieDAO;
	
	@RequestMapping("/")
	public ModelAndView movies(){
		ModelAndView mv = new ModelAndView("movies");
		List<Movie> movies = movieDAO.getMovies();
		mv.addObject("movies", movies);
		return mv;
	}
	
	@RequestMapping("/{movieId}")
	public ModelAndView getMovie(@PathVariable int movieId){
		ModelAndView mv = new ModelAndView("movie");
		Movie movie = movieDAO.getMovie(movieId);
		mv.addObject("movie", movie);
		return mv;
	}
}
