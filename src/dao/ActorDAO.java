package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.ActorMapper;
import mapper.MovieMapper;
import mapper.ScoreActorMapper;
import model.Actor;
import model.Movie;
import model.ScoreActor;

import org.springframework.jdbc.core.JdbcTemplate;

public class ActorDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ActorDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Actor getActor(String id){
		String query = "SELECT * FROM Actor WHERE id = ? ORDER BY name";
		Actor actor = jdbcTemplate.queryForObject(query, new Object[]{id}, new ActorMapper());
		return actor;
	}
	
	public List<Actor> getActorByName(String name){
		String query = "SELECT * FROM Actor WHERE name = ? GROUP BY name";
		List<Actor> actor = jdbcTemplate.query(query, new Object[]{name}, new ActorMapper());
		return actor;
	}
	
	public ScoreActor getScoreActor(String id){
		String query = "SELECT DISTINCT A.id, A.name, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Actor A, Movie M, Acts_in AI "
				+ "WHERE AI.actorID = ? AND M.id = AI.movieID AND AI.actorID = A.id "
				+ "GROUP BY AI.actorID";
		ScoreActor actor = jdbcTemplate.queryForObject(query, new Object[]{id}, new ScoreActorMapper());
		return actor;
	}
	
	public List<Actor> getActors(){
		String query = "SELECT * FROM Actor ORDER BY name";
		List<Actor> actors = jdbcTemplate.query(query, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActors(int limit){
		String query = "SELECT * FROM Actor ORDER BY name LIMIT ? ";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{limit}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActors(int limit, int offset){
		String query = "SELECT * FROM Actor ORDER BY name LIMIT ? OFFSET ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{limit, offset}, new ActorMapper());
		return actors;
	}
	
	public List<ScoreActor> getScoreActors(){
		String query = "SELECT A.id, A.name, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Actor A, Movie M, Acts_in AI "
				+ "WHERE AI.actorID = A.id AND M.id = AI.movieID "
				+ "GROUP BY A.name "
				+ "ORDER BY AVG(M.rtAudienceScore) desc";
		List<ScoreActor> actors = jdbcTemplate.query(query, new ScoreActorMapper());
		return actors;
	}
	
	public List<ScoreActor> getScoreActors(int limit){
		String query = "SELECT A.id, A.name, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Actor A, Movie M, Acts_in AI "
				+ "WHERE AI.actorID = A.id AND M.id = AI.movieID "
				+ "GROUP BY A.name "
				+ "ORDER BY AVG(M.rtAudienceScore) desc "
				+ "LIMIT ?";
		List<ScoreActor> actors = jdbcTemplate.query(query, new Object[]{limit}, new ScoreActorMapper());
		return actors;
	}
	
	public List<ScoreActor> getScoreActors(int limit, int offset){
		String query = "SELECT A.id, A.name, AVG(M.rtAudienceScore) as avgScore "
				+ "FROM Actor A, Movie M, Acts_in AI "
				+ "WHERE AI.actorID = A.id AND M.id = AI.movieID "
				+ "GROUP BY A.name "
				+ "ORDER BY AVG(M.rtAudienceScore) desc "
				+ "LIMIT ? "
				+ "OFFSET ?";
		List<ScoreActor> actors = jdbcTemplate.query(query, new Object[]{limit, offset}, new ScoreActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name){
		String query = "SELECT * FROM Actor WHERE name LIKE ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{"%"+name+"%"}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name, int limit){
		String query = "SELECT * FROM Actor WHERE name LIKE ? LIMIT ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{"%"+name+"%", limit}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name, int limit, int offset){
		String query = "SELECT * FROM Actor WHERE name LIKE ? LIMIT ? OFFSET ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{"%"+name+"%", limit, offset}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID){
		String query = "SELECT id, name FROM Actor, Acts_in WHERE id = actorID AND movieID = ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID, int limit){
		String query = "SELECT id, name FROM Actor, Acts_in WHERE id = actorID AND movieID = ? LIMIT ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID, limit}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID, int limit, int offset){
		String query = "SELECT id, name FROM Actor, Acts_in WHERE id = actorID AND movieID = ? LIMIT ? OFFSET ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID, limit, offset}, new ActorMapper());
		return actors;
	}
	
}
