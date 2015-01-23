package com.kriloleg.englishlearning.exceptions;

public class FileNotFoundException extends RuntimeException {
    private String message;

    public FileNotFoundException(String message) {
        this.message = message;
    }

}
