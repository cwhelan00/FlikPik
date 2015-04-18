package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Genre;

public class GenreMapper implements RowMapper<Genre>{

	@Override
	public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
		Genre genre = new Genre();
		genre.setType(rs.getString("type"));
		return genre;
	}

}
