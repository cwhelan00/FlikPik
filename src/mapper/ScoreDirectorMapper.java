package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.ScoreDirector;

public class ScoreDirectorMapper implements RowMapper<ScoreDirector>{

	@Override
	public ScoreDirector mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreDirector director = new ScoreDirector();
		director.setId(rs.getString("id"));
		director.setName(rs.getString("name"));
		director.setAvgScore(rs.getDouble("avgScore"));
		return director;
	}

}
