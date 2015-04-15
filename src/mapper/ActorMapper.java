package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Actor;

public class ActorMapper implements RowMapper<Actor>{

	@Override
	public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Actor actor = new Actor();
		actor.setId(rs.getString("id"));
		actor.setName(rs.getString("name"));
		return actor;
	}

}
