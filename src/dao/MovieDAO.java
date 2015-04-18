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
		String query = "SELECT * FROM Movie WHERE id = ? GROUP BY title";
		Movie movie = jdbcTemplate.queryForObject(query, new Object[]{id}, new MovieMapper());
		return movie;
	}
	
	public List<Movie> getMovies(){
		String query = "SELECT * FROM Movie GROUP BY title ORDER BY rtAudienceScore desc";
		List<Movie> movies = jdbcTemplate.query(query, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMovies(int limit){
		String query = "SELECT * FROM Movie GROUP BY title ORDER BY rtAudienceScore desc LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMovies(int limit, int offset){
		String query = "SELECT * FROM Movie GROUP BY title ORDER BY rtAudienceScore desc LIMIT ? OFFSET ? ";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title){
		String query = "SELECT * FROM Movie WHERE title LIKE ? GROUP BY title ORDER BY rtAudienceScore desc";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{"%"+title+"%"}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title, int limit){
		String query = "SELECT * FROM Movie WHERE title LIKE ? GROUP BY title ORDER BY rtAudienceScore desc LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{"%"+title+"%", limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesLike(String title, int limit, int offset){
		String query = "SELECT * FROM Movie WHERE title LIKE ? GROUP BY title ORDER BY rtAudienceScore desc LIMIT ? OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{"%"+title+"%", limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMovieByTitle(String title){
		String query = "SELECT * FROM Movie WHERE title = ? GROUP BY title";
		List<Movie> movie = jdbcTemplate.query(query, new Object[]{title}, new MovieMapper());
		return movie;
	}
	
	public List<Movie> getMoviesByDirector(String directorID){
		String query = "SELECT * FROM Movie WHERE directorID = ? GROUP BY title ORDER BY year";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByDirector(String directorID, int limit){
		String query = "SELECT * FROM Movie WHERE directorID = ? GROUP BY title ORDER BY year LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByDirector(String directorID, int limit, int offset){
		String query = "SELECT * "
				+ "FROM Movie "
				+ "WHERE directorID = ? "
				+ "GROUP BY title "
				+ "ORDER BY year "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{directorID, limit, offset}, new MovieMapper());
		return movies;
	}
	// need to write query for get movies by actor
	public List<Movie> getMoviesByActor(String actorID){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Acts_in AI "
				+ "WHERE M.id = AI.movieID AND AI.actorID = ? "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{actorID}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByActor(String actorID, int limit){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Acts_in AI "
				+ "WHERE M.id = AI.movieID AND AI.actorID = ? "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year "
				+ "LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{actorID, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByActor(String actorID, int limit, int offset){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Acts_in AI "
				+ "WHERE M.id = AI.movieID AND AI.actorID = ? "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{actorID, limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByGenre(String genreType){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_genre HG "
				+ "WHERE HG.genreType = ? AND HG.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.rtAudienceScore desc";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{genreType}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByGenre(String genreType, int limit){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_genre HG "
				+ "WHERE HG.genreType = ? AND HG.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.rtAudienceScore desc "
				+ "LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{genreType, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByGenre(String genreType, int limit, int offset){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_genre HG "
				+ "WHERE HG.genreType = ? AND HG.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.rtAudienceScore desc "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{genreType, limit, offset}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByTag(int tagID){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_tag HT "
				+ "WHERE HT.tagID = ? AND HT.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{tagID}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByTag(int tagID, int limit){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_tag HT "
				+ "WHERE HT.tagID = ? AND HT.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year "
				+ "LIMIT ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{tagID, limit}, new MovieMapper());
		return movies;
	}
	
	public List<Movie> getMoviesByTag(int tagID, int limit, int offset){
		String query = "SELECT DISTINCT M.title, M.id, M.year, M.rtAudienceScore, M.rt_url, M.imdb_url, M.directorID "
				+ "FROM Movie M, Has_tag HT "
				+ "WHERE HT.tagID = ? AND HT.movieID = M.id "
				+ "GROUP BY M.title "
				+ "ORDER BY M.year "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<Movie> movies = jdbcTemplate.query(query, new Object[]{tagID, limit, offset}, new MovieMapper());
		return movies;
	}
}
