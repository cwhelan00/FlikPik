package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.DirectorMapper;
import model.Director;

import org.springframework.jdbc.core.JdbcTemplate;

public class DirectorDAO {

	private JdbcTemplate jdbcTemplate;
	
	public DirectorDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Director getDirector(String id){
		String query = "SELECT * FROM Director WHERE id = ?";
		Director director = jdbcTemplate.queryForObject(query, new Object[]{id}, new DirectorMapper());
		return director;
	}
	
	public List<Director> getDirectors(){
		String query = "SELECT * FROM Director";
		List<Director> directors = jdbcTemplate.query(query, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectors(int limit){
		String query = "SELECT * FROM Director LIMIT ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{limit}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectors(int limit, int offset){
		String query = "SELECT * FROM Director LIMIT ? OFFSET ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{limit, offset}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name){
		String query = "SELECT * FROM Director WHERE name LIKE '%?%'";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{name}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name, int limit){
		String query = "SELECT * FROM Director WHERE name LIKE '%?%' LIMIT ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{name, limit}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name, int limit, int offset){
		String query = "SELECT * FROM Director WHERE name LIKE '%?%' LIMIT ? OFFSET ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{name, limit, offset}, new DirectorMapper());
		return directors;
	}
}
