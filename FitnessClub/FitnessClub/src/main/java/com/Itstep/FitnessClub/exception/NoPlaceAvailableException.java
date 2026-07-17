package com.Itstep.FitnessClub.exception;

public class NoPlaceAvailableException extends RuntimeException {
    public NoPlaceAvailableException(String message) {
        super(message + " No place available");
    }
}
