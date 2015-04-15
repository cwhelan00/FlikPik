package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Director;

public class DirectorMapper implements RowMapper<Director>{

	@Override
	public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
		Director director = new Director();
		director.setId(rs.getString("id"));
		director.setName(rs.getString("name"));
		return director;
	}

}
