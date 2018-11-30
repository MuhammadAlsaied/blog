package com.muhammadalsaied.blog.backend.controller;

import com.muhammadalsaied.blog.backend.dao.UserDao;
import com.muhammadalsaied.blog.backend.dto.User;
import com.muhammadalsaied.blog.backend.exceptionhandling.BadRequestException;
import com.muhammadalsaied.blog.backend.exceptionhandling.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "users")
    public ResponseEntity getAllUsers() {
        List<User> users = userDao.findAll();
        return new ResponseEntity(users, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("User", id);
        }
    }

    @PostMapping(value = "users")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        if (userDao.existsByEmail(user.getEmail())) {
            throw new BadRequestException(String.format("User with email='%s' already registered", user.getEmail()));
        }
        userDao.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "users")
    public ResponseEntity updateUser(@Valid @RequestBody User user) {
        if (user.getId() == null) {
            throw new BadRequestException("user id is required");
        }
        if (!userDao.existsById(user.getId())) {
            throw new ResourceNotFoundException("User", user.getId());
        }
        userDao.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping(value = "users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        if (userDao.existsById(id)) {
            userDao.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            throw new ResourceNotFoundException("User", id);
        }
    }

}
