package com.muhammadalsaied.blog.backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 *  muhammadalsaied96@gmail.com
 */
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
           .ignoring()
               .antMatchers("/**");
    }
}