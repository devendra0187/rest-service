package com.example.restservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourseNotFoundException extends Throwable {


    public ResourseNotFoundException(String s) {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends Exception {

        /**
         * Instantiates a new Resource not found exception.
         *
         * @param message the message
         */
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
}