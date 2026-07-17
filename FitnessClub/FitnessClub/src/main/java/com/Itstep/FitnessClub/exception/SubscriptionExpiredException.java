package com.Itstep.FitnessClub.exception;

public class SubscriptionExpiredException extends RuntimeException {
    public SubscriptionExpiredException(String message) {
        super(message + " Subscription expired");
    }
}
