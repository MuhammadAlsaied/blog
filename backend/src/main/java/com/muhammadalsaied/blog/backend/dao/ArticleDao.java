package com.muhammadalsaied.blog.backend.dao;

import com.muhammadalsaied.blog.backend.dto.Article;
import com.muhammadalsaied.blog.backend.dto.Category;
import com.muhammadalsaied.blog.backend.dto.Tag;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {
	List<Article> findFirst10ByActive(boolean active, Sort sort);

	List<Article> findFirst5ByActive(boolean active, Sort sort);

	List<Article> findByTagsAndActive(Tag tag, boolean active, Pageable pageable);

	List<Article> findByCategoryAndActive(Category tag, boolean active, Pageable pageable);
}
