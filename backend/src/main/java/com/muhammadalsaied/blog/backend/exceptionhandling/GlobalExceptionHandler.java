package com.muhammadalsaied.blog.backend.exceptionhandling;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorTemplate> handleResourceNotFoundException(ResourceNotFoundException exception) {

        ErrorTemplate error = new ErrorTemplate(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorTemplate> handleBadRequestException(BadRequestException exception) {
        ErrorTemplate error = new ErrorTemplate(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        String message = String.format("The parameter '%s' of value '%s' could not be converted to type '%s'", exception.getName(), exception.getValue(), exception.getRequiredType().getSimpleName());
        ErrorTemplate error = new ErrorTemplate(message, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpHeaders hh, HttpStatus hs, WebRequest wr) {
        String message = String.format("Method '%s' is not supported", e.getMethod());
        ErrorTemplate error = new ErrorTemplate(message, hs);
        return new ResponseEntity<>(error, hs);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException e, HttpHeaders hh, HttpStatus hs, WebRequest wr) {
        ErrorTemplate error = new ErrorTemplate(e.getMessage(), hs);
        return new ResponseEntity<>(error, hs);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus hs, WebRequest request) {
        String message = "";
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException ex = (InvalidFormatException) e.getCause();
            message = String.format("'%s' not a valid %s value",ex.getValue(),ex.getTargetType().getSimpleName());
        }else{
            message = "JSON parse error";
        }
        ErrorTemplate error = new ErrorTemplate(message, hs);

        return new ResponseEntity<>(error, hs);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus hs, WebRequest request) {
        ErrorTemplate error = new ErrorTemplate("Validation failed!", hs);
        error.addFieldErrors(e.getBindingResult().getFieldErrors());
        return new ResponseEntity<>(error, hs);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception e, Object o, HttpHeaders hh, HttpStatus hs, WebRequest wr) {
        ErrorTemplate error = new ErrorTemplate(e.getMessage(), hs);
        return new ResponseEntity<>(error, hs);
    }

}
