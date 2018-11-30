package com.muhammadalsaied.blog.backend.dao;

import com.muhammadalsaied.blog.backend.dto.Tag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Muhammed Alsaied On Nov 18, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository
public interface TagDao extends JpaRepository<Tag, Long> {
	@Query(value = "SELECT t.* FROM tag t JOIN article_tags ttm ON t.id = ttm.tags_id GROUP BY t.id ORDER BY COUNT(t.id) DESC LIMIT 5", nativeQuery = true)
	List<Tag> findPopularTags();
	@Query(value = "SELECT COUNT(*) FROM `article_tags` WHERE tags_id = :id ", nativeQuery = true)
	Long count(@Param("id") Long id);
}
