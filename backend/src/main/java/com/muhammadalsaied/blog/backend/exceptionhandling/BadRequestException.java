package com.muhammadalsaied.blog.backend.exceptionhandling;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 *  muhammadalsaied96@gmail.com
 */
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
    

}
