package dao;

import java.util.*;

import mapper.MovieMapper;
import model.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MovieDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public MovieDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Movie getMovie(int id){
		String query = "SELECT * FROM Movie WHERE id = ?";
		Movie movie = jdbcTemplate.queryForObject(query, new Object[]{id}, new MovieMapper());
		return movie;
	}
	
	public List<Movie> getMovies(){
		String query = "SELECT * FROM Movie";
		List<Movie> movies = jdbcTemplate.query(query, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMovies(int limit){
		String query = "SELECT * FROM Movie LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMovies(int limit, int offset){
		String query = "SELECT * FROM Movie LIMIT ? OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title){
		String query = "SELECT * FROM Movie WHERE title LIKE '%?%'";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{title}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title, int limit){
		String query = "SELECT * FROM Movie WHERE title LIKE '%?%' LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{title, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title, int limit, int offset){
		String query = "SELECT * FROM Movie WHERE title LIKE '%?%' LIMIT ? OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{title, limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByDirector(String directorID){
		String query = "SELECT * FROM Movie WHERE directorID = ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByDirector(String directorID, int limit){
		String query = "SELECT * FROM Movie WHERE directorID = ? LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByDirector(String directorID, int limit, int offset){
		String query = "SELECT * FROM Movie WHERE directorID = ? LIMIT ? OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID, limit, offset}, new MovieMapper());
		return movies;
	}
}
