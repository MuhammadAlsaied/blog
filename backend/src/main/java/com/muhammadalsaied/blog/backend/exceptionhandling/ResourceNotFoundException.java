package com.muhammadalsaied.blog.backend.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String message;

    public ResourceNotFoundException(String resource) {
        super();
        message = String.format("'%s' couldn't be found", resource);
    }

    public ResourceNotFoundException(String resource, Long id) {
        super();
        message = String.format("'%s' with id='%s' couldn't be found", resource, id);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
