package com.university.studyplanapi.exception;

public class UserConflictException extends RuntimeException{
    public UserConflictException(String message) {
        super(message);
    }
}
