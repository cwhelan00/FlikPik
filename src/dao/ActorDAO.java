package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.ActorMapper;
import model.Actor;

import org.springframework.jdbc.core.JdbcTemplate;

public class ActorDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ActorDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Actor getActor(String id){
		String query = "SELECT * FROM Actor WHERE id = ?";
		Actor actor = jdbcTemplate.queryForObject(query, new Object[]{id}, new ActorMapper());
		return actor;
	}
	
	public List<Actor> getActors(){
		String query = "SELECT * FROM Actor";
		List<Actor> actors = jdbcTemplate.query(query, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name){
		String query = "SELECT * FROM Actor WHERE name LIKE '%?%'";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{name}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name, int limit){
		String query = "SELECT * FROM Actor WHERE name LIKE '%?%' LIMIT ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{name, limit}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsLike(String name, int limit, int offset){
		String query = "SELECT * FROM Actor WHERE name LIKE '%?%' LIMIT ? OFFSET ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{name, limit, offset}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID){
		String query = "SELECT A.id, A.name FROM Actor, Acts_in WHERE id = actorID AND movieID = ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID, int limit){
		String query = "SELECT A.id, A.name FROM Actor, Acts_in WHERE id = actorID AND movieID = ? LIMIT ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID, limit}, new ActorMapper());
		return actors;
	}
	
	public List<Actor> getActorsByMovie(int movieID, int limit, int offset){
		String query = "SELECT A.id, A.name FROM Actor, Acts_in WHERE id = actorID AND movieID = ? LIMIT ? OFFSET ?";
		List<Actor> actors = jdbcTemplate.query(query, new Object[]{movieID, limit, offset}, new ActorMapper());
		return actors;
	}
	
}
