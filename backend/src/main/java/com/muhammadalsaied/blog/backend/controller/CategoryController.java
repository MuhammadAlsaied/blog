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
import com.muhammadalsaied.blog.backend.dao.CategoryDao;
import com.muhammadalsaied.blog.backend.dto.Article;
import com.muhammadalsaied.blog.backend.dto.Category;
import com.muhammadalsaied.blog.backend.exceptionhandling.BadRequestException;
import com.muhammadalsaied.blog.backend.exceptionhandling.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ArticleDao articleDao;

	@GetMapping(value = "/{id}")
	public ResponseEntity getCategory(@PathVariable("id") Long id) {
		Optional<Category> category = categoryDao.findById(id);
		if (!category.isPresent()) {
			throw new ResourceNotFoundException("Tag", id);
		}
		return new ResponseEntity(category, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "")
	public ResponseEntity getCategories() {
		List<Category> catgeories = categoryDao.findCategoriesByActive(true);
		return new ResponseEntity(catgeories, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}/articles/page/{page}")
	public ResponseEntity getArticlesByCategory(@PathVariable("id") Long id, @PathVariable("page") int page) {
		if (page < 1) {
			throw new BadRequestException("Page number can not be less than 1!.");
		}
		Optional<Category> category = categoryDao.findById(id);
		if (!category.isPresent()) {
			throw new ResourceNotFoundException("Category", id);
		}
		List<Article> articles = articleDao.findByCategoryAndActive(category.get(), true,
				PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "id")));
		return new ResponseEntity(articles, HttpStatus.ACCEPTED);
	}
}
