package com.university.studyplanapi.exception;

public class InvalidJSONException extends RuntimeException{
    public InvalidJSONException(String message) {
        super(message);
    }
}
