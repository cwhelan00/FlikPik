package dao;

import java.util.List;

import javax.sql.DataSource;

import mapper.TagMapper;
import model.Tag;

import org.springframework.jdbc.core.JdbcTemplate;

public class TagDAO {

	private JdbcTemplate jdbcTemplate;
	
	public TagDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Tag getTag(int tagID){
		String query = "SELECT * FROM Tag WHERE id = ?";
		Tag tag = jdbcTemplate.queryForObject(query, new Object[]{tagID}, new TagMapper());
		return tag;
	}
	
	public List<Tag> getTags(){
		String query = "SELECT * FROM Tag";
		List<Tag> tags = jdbcTemplate.query(query, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTagsByMovie(int movieID){
		String query = "SELECT id, value FROM Tag, Has_tag WHERE id = tagID AND movieID = ?";
		List<Tag> tags = jdbcTemplate.query(query, new Object[]{movieID}, new TagMapper());
		return tags;
	}
}
