package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException{
    private HttpStatus status;
    private String massage;

    public BlogAPIException(HttpStatus status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public BlogAPIException(String message, HttpStatus status, String massage) {
        super(message);
        this.status = status;
        this.massage = massage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
