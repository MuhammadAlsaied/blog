/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muhammadalsaied.blog.backend.dao;

import com.muhammadalsaied.blog.backend.dto.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammed Alsaied
 */
@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {
    
	List<Category> findCategoriesByActive(boolean active);
}
