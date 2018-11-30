package com.muhammadalsaied.blog.backend;

import com.muhammadalsaied.blog.backend.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void tesUser() {
        /*   User user = new User();
        user.setFirstName("Muhammad");
        user.setLastName("Alsaied");
        user.setEmail("muhammadAlsaied96@gmail.com");
        user.setPassword("pass");
        user.setDescription("My name is Muhammad Alsaeid");
        user.setRole("admin");
        Assert.assertEquals("Error adding user to database", user, userDao.save(user));
        Assert.assertEquals("Error retrieving user from database", user, userDao.findByEmail(user.getEmail()));
         */

    }
}
