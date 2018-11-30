package com.muhammadalsaied.blog.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammadalsaied.blog.backend.dao.ArticleDao;
import com.muhammadalsaied.blog.backend.dao.TagDao;
import com.muhammadalsaied.blog.backend.dto.Article;
import com.muhammadalsaied.blog.backend.dto.Tag;
import com.muhammadalsaied.blog.backend.exceptionhandling.BadRequestException;
import com.muhammadalsaied.blog.backend.exceptionhandling.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/api/tags")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {
	@Autowired
	private TagDao tagDao;

	@Autowired
	private ArticleDao articleDao;

	@GetMapping(value = "/{id}")
	public ResponseEntity getTag(@PathVariable("id") Long id) {
		Optional<Tag> tag = tagDao.findById(id);
		if(!tag.isPresent()) {
			throw new ResourceNotFoundException("Tag",id);
		}
		return new ResponseEntity(tag, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "")
	public ResponseEntity getPopularTags() {
		List<Tag> tags = tagDao.findPopularTags();
		return new ResponseEntity(tags, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}/count")
	public ResponseEntity getTagCount(@PathVariable("id") Long id) {
		Long count = tagDao.count(id);
		return new ResponseEntity(count, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}/articles/page/{page}")
	public ResponseEntity getArticlesByTag(@PathVariable("id") Long id, @PathVariable("page") int page) {
		if (page < 1) {
			throw new BadRequestException("Page number can not be less than 1!.");
		}
		Optional<Tag> tag = tagDao.findById(id);
		if (!tag.isPresent()) {
			throw new ResourceNotFoundException("Tag", id);
		}
		List<Article> articles = articleDao.findByTagsAndActive(tag.get(), true,
				PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "id")));
		return new ResponseEntity(articles, HttpStatus.ACCEPTED);
	}
}