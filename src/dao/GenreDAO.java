package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.GenreMapper;
import model.Genre;

import org.springframework.jdbc.core.JdbcTemplate;

public class GenreDAO {

	JdbcTemplate jdbcTemplate;
	
	public GenreDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Genre getGenre(String type){
		String query = "SELECT * FROM Genre WHERE type = ?";
		Genre genre = jdbcTemplate.queryForObject(query, new Object[]{type}, new GenreMapper());
		return genre;
	}
	
	public List<Genre> getGenreByType(String type){
		String query = "SELECT * FROM Genre WHERE type = ?";
		List<Genre> genre = jdbcTemplate.query(query, new Object[]{type}, new GenreMapper());
		return genre;
	}
	
	public List<Genre> getGenres(){
		String query = "SELECT * FROM Genre";
		List<Genre> genres = jdbcTemplate.query(query, new GenreMapper());
		return genres;
	}
	
	public List<Genre> getGenresLike(String type){
		String query = "SELECT * FROM Genre WHERE type LIKE ?";
		List<Genre> genres = jdbcTemplate.query(query,new Object[]{"%"+type+"%"}, new GenreMapper());
		return genres;
	}
	
	public List<Genre> getGenreByMovie(int movieID){
		String query = "SELECT type FROM Has_genre, Genre WHERE movieID = ? AND genreType = type";
		List<Genre> genres = jdbcTemplate.query(query, new Object[]{movieID}, new GenreMapper());
		return genres;
	}
}
