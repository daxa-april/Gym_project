package com.Itstep.FitnessClub.exception;

public class TrainingNotFoundException extends RuntimeException {
    public TrainingNotFoundException(String message) {
        super(message + " Training not found");
    }
}
