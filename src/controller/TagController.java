package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.TagDAO;
import model.Tag;

@Controller
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	TagDAO tagDAO;
	
	private static final int LIMIT = 50;
	
	@RequestMapping("")
	public ModelAndView tags(){
		ModelAndView mv = new ModelAndView("tags");
		List<Tag> tags = tagDAO.getTags(LIMIT);
		mv.addObject("pageNum", 0);
		mv.addObject("tags", tags);
		return mv;
	}
	
	@RequestMapping("/page/{pageNum}")
	public ModelAndView tagsPage(@PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("tags");
		List<Tag> tags = tagDAO.getTags(LIMIT, offset);
		mv.addObject("pageNum", pageNum);
		mv.addObject("tags", tags);
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView tagsSearch(@RequestParam("value") String value){
		ModelAndView mv = new ModelAndView("tagsSearch");
		List<Tag> tags = tagDAO.getTagsLike(value, LIMIT);
		List<Tag> exact = tagDAO.getTagByValue(value);
		if(!exact.isEmpty()){
			mv.addObject("exactTag", exact.get(0));
		}
		mv.addObject("pageNum", 0);
		mv.addObject("tags", tags);
		mv.addObject("searchValue", value);
		return mv;
	}
	
	@RequestMapping("/search/page/{pageNum}")
	public ModelAndView tagsSearchPage(@RequestParam("value") String value, @PathVariable int pageNum){
		int offset = pageNum * LIMIT;
		ModelAndView mv = new ModelAndView("tagsSearch");
		List<Tag> tags = tagDAO.getTagsLike(value, LIMIT, offset);
		List<Tag> exact = tagDAO.getTagByValue(value);
		if(!exact.isEmpty()){
			mv.addObject("exactTag", exact.get(0));
		}
		mv.addObject("tags", tags);
		mv.addObject("searchValue", value);
		return mv;
	}

}
