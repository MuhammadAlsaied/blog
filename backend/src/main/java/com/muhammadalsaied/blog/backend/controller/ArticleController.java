package com.muhammadalsaied.blog.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammadalsaied.blog.backend.dao.ArticleDao;
import com.muhammadalsaied.blog.backend.dao.TagDao;
import com.muhammadalsaied.blog.backend.dto.Article;
import com.muhammadalsaied.blog.backend.exceptionhandling.BadRequestException;
import com.muhammadalsaied.blog.backend.exceptionhandling.ResourceNotFoundException;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@RestController
@RequestMapping(value = "/api/articles")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

	@Autowired
	private ArticleDao articleDao;

	@GetMapping(value = "")
	public ResponseEntity getLatestArticles() {
		List<Article> articles = articleDao.findFirst10ByActive(true, Sort.by(Sort.Direction.DESC, "id"));
		return new ResponseEntity(articles, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/popular")
	public ResponseEntity getPopularArticles() {
		List<Article> articles = articleDao.findFirst5ByActive(true, Sort.by(Sort.Direction.DESC, "views"));
		return new ResponseEntity(articles, HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity getArticle(@PathVariable("id") Long id) {
		Optional<Article> article = articleDao.findById(id);
		if (article.isPresent()) {
			return new ResponseEntity<>(article.get(), HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Article", id);
		}
	}

	@GetMapping(value = "/{id}/increment")
	public ResponseEntity incrementViews(@PathVariable("id") Long id) {
		Optional<Article> article = articleDao.findById(id);
		if (article.isPresent()) {
			Article obj = article.get();
			obj.setViews(obj.getViews() + 1);
			articleDao.save(obj);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("Article", id);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity addArticle(@Valid @RequestBody Article article) {
		article.setDateCreated(new Date());
		articleDao.save(article);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(value = "")
	public ResponseEntity updateArticle(@Valid @RequestBody Article article) {
		if (article.getId() == null) {
			throw new BadRequestException("Article id is required");
		}
		if (!articleDao.existsById(article.getId())) {
			throw new ResourceNotFoundException("Article", article.getId());
		}
		articleDao.save(article);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteArticle(@PathVariable("id") Long id) {
		if (articleDao.existsById(id)) {
			articleDao.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} else {
			throw new ResourceNotFoundException("Article", id);
		}
	}
}