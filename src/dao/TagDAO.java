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
	
	public List<Tag> getTagByValue(String value){
		String query = "SELECT * FROM Tag WHERE value = ?";
		List<Tag> tag = jdbcTemplate.query(query, new Object[]{value}, new TagMapper());
		return tag;
	}
	
	public List<Tag> getTags(){
		String query = "SELECT * FROM Tag ORDER BY value";
		List<Tag> tags = jdbcTemplate.query(query, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTags(int limit){
		String query = "SELECT * FROM Tag ORDER BY value LIMIT ?";
		List<Tag> tags = jdbcTemplate.query(query, new Object[]{limit}, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTags(int limit, int offset){
		String query = "SELECT * FROM Tag ORDER BY value LIMIT ? OFFSET ?";
		List<Tag> tags = jdbcTemplate.query(query, new Object[]{limit, offset}, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTagsLike(String value){
		String query = "SELECT * FROM Tag WHERE value LIKE ?";
		List<Tag> tags = jdbcTemplate.query(query,new Object[]{"%"+value+"%"}, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTagsLike(String value, int limit){
		String query = "SELECT * FROM Tag WHERE value LIKE ? LIMIT ?";
		List<Tag> tags = jdbcTemplate.query(query,new Object[]{"%"+value+"%", limit}, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTagsLike(String value, int limit, int offset){
		String query = "SELECT * FROM Tag WHERE value LIKE ? LIMIT ? OFFSET ?";
		List<Tag> tags = jdbcTemplate.query(query,new Object[]{"%"+value+"%", limit, offset}, new TagMapper());
		return tags;
	}
	
	public List<Tag> getTagsByMovie(int movieID){
		String query = "SELECT id, value FROM Tag, Has_tag WHERE id = tagID AND movieID = ?";
		List<Tag> tags = jdbcTemplate.query(query, new Object[]{movieID}, new TagMapper());
		return tags;
	}
}
