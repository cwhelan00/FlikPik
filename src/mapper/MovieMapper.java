package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.*;

public class MovieMapper implements RowMapper<Movie>{

	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movie movie = new Movie();
		movie.setId(rs.getInt("id"));
		movie.setTitle(rs.getString("title"));
		movie.setYear(rs.getInt("year"));
		movie.setImdbPictureUrl(rs.getString("imdb_url"));
		movie.setRtPictureUrl(rs.getString("rt_url"));
		movie.setDirectorId(rs.getString("directorID"));
		movie.setRtAudienceScore(rs.getInt("rtAudienceScore"));
		return movie;
	}

}
