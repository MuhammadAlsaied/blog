package com.muhammadalsaied.blog.backend.exceptionhandling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

/**
 * Created by @author Muhammed Alsaied On Nov 9, 2018
 * muhammadalsaied96@gmail.com
 */
public class ErrorTemplate {
    
    private int status;
    private String message;
    private List<SubError> subErrors = new ArrayList();
    
    public ErrorTemplate(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public List<SubError> getSubErrors() {
        return subErrors;
    }
    
    public void addSubError(SubError subError) {
        this.subErrors.add(subError);
    }
    
    public void addFieldErrors(List<FieldError> errors) {
        Iterator<FieldError> i = errors.iterator();
        while (i.hasNext()) {
            FieldError fieldError = i.next();
            SubError subError = new SubError(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
            addSubError(subError);
        }
    }
    
    static class SubError {
        
        private String field;
        private Object rejectedValue;
        private String message;
        
        public SubError(String field, Object rejectedValue, String message) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.message = message;
        }
        
        public String getField() {
            return field;
        }
        
        public Object getRejectedValue() {
            return rejectedValue;
        }
        
        public String getMessage() {
            return message;
        }
        
    }
}
