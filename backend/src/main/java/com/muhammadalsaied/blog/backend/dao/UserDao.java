package com.muhammadalsaied.blog.backend.dao;

import com.muhammadalsaied.blog.backend.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public boolean existsByEmail(String email);

}
