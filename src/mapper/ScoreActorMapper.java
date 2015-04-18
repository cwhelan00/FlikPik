package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ScoreActor;

import org.springframework.jdbc.core.RowMapper;

public class ScoreActorMapper implements RowMapper<ScoreActor>{

	@Override
	public ScoreActor mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreActor actor = new ScoreActor();
		actor.setId(rs.getString("id"));
		actor.setName(rs.getString("name"));
		actor.setAvgScore(rs.getDouble("avgScore"));
		return actor;
	}

}
