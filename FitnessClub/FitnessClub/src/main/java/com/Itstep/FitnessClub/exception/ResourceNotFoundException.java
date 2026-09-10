package com.Itstep.FitnessClub.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message + " Training not found");
    }
}
