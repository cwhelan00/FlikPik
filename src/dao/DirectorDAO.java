package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.DirectorMapper;
import mapper.ScoreDirectorMapper;
import model.Director;
import model.ScoreDirector;

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
	
	public List<Director> getDirectorByName(String name){
		String query = "SELECT * FROM Director WHERE name = ? GROUP BY name";
		List<Director> director = jdbcTemplate.query(query, new Object[]{name}, new DirectorMapper());
		return director;
	}
	
	public Director getDirectorByMovie(int movieID){
		String query = "SELECT D.id, D.name FROM Director D, Movie M WHERE D.id = M.directorID AND M.id = ?";
		Director director = jdbcTemplate.queryForObject(query, new Object[]{movieID}, new DirectorMapper());
		return director;
	}
	
	public ScoreDirector getScoreDirector(String id){
		String query = "SELECT DISTINCT D.name, D.id, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Director D, Movie M "
				+ "WHERE M.directorID = D.id AND D.id = ? "
				+ "GROUP BY D.id";
		ScoreDirector director = jdbcTemplate.queryForObject(query, new Object[]{id}, new ScoreDirectorMapper());
		return director;
	}
	
	public List<Director> getDirectors(){
		String query = "SELECT * FROM Director ORDER BY name";
		List<Director> directors = jdbcTemplate.query(query, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectors(int limit){
		String query = "SELECT * FROM Director ORDER BY name LIMIT ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{limit}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectors(int limit, int offset){
		String query = "SELECT * FROM Director ORDER BY name LIMIT ? OFFSET ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{limit, offset}, new DirectorMapper());
		return directors;
	}
	
	public List<ScoreDirector> getScoreDirectors(){
		String query = "SELECT DISTINCT D.name, D.id, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Director D, Movie M "
				+ "WHERE M.directorID = D.id "
				+ "GROUP BY D.id "
				+ "ORDER BY AVG(M.rtAudienceScore) desc";
		List<ScoreDirector> directors = jdbcTemplate.query(query, new ScoreDirectorMapper());
		return directors;
	}
	
	public List<ScoreDirector> getScoreDirectors(int limit){
		String query = "SELECT DISTINCT D.name, D.id, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Director D, Movie M "
				+ "WHERE M.directorID = D.id "
				+ "GROUP BY D.id "
				+ "ORDER BY AVG(M.rtAudienceScore) desc "
				+ "LIMIT ?";
		List<ScoreDirector> directors = jdbcTemplate.query(query, new Object[]{limit}, new ScoreDirectorMapper());
		return directors;
	}
	
	public List<ScoreDirector> getScoreDirectors(int limit, int offset){
		String query = "SELECT DISTINCT D.name, D.id, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Director D, Movie M "
				+ "WHERE M.directorID = D.id "
				+ "GROUP BY D.id "
				+ "ORDER BY AVG(M.rtAudienceScore) desc "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<ScoreDirector> directors = jdbcTemplate.query(query, new Object[]{limit, offset}, new ScoreDirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name){
		String query = "SELECT * FROM Director WHERE name LIKE ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{"%"+name+"%"}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name, int limit){
		String query = "SELECT * FROM Director WHERE name LIKE ? LIMIT ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{"%"+name+"%", limit}, new DirectorMapper());
		return directors;
	}
	
	public List<Director> getDirectorsLike(String name, int limit, int offset){
		String query = "SELECT * FROM Director WHERE name LIKE ? LIMIT ? OFFSET ?";
		List<Director> directors = jdbcTemplate.query(query, new Object[]{"%"+name+"%", limit, offset}, new DirectorMapper());
		return directors;
	}
}
