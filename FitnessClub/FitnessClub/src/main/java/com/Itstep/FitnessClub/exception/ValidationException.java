package com.Itstep.FitnessClub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Daria Pevets
 **/
@AllArgsConstructor
@Getter
public class ValidationException extends RuntimeException {

    private final String message;


}
