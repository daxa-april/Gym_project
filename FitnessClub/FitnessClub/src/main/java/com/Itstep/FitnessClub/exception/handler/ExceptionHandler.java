//package com.Itstep.FitnessClub.exception.handler;
//
//import com.Itstep.FitnessClub.exception.NoPlaceAvailableException;
//import com.Itstep.FitnessClub.exception.ResourceNotFoundException;
//import com.Itstep.FitnessClub.exception.SubscriptionExpiredException;
//import io.swagger.v3.oas.annotations.Hidden;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import static java.time.LocalDateTime.now;
//import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;
//import static org.springframework.http.HttpStatus.NOT_FOUND;
//
///**
// * @author Daria Pevets
// **/
//@RestControllerAdvice
//public class ExceptionHandler {
//
//    @Hidden
//    @org.springframework.web.bind.annotation.ExceptionHandler(NoPlaceAvailableException.class)
//    @ResponseStatus(NOT_ACCEPTABLE)
//    public ExceptionResponse handleNoPlaceAvailableException(NoPlaceAvailableException NoPlaceException) {
//        return ExceptionResponse.builder()
//                .message(NoPlaceException.getMessage())
//                .code("400")
//                .timestamp(now())
//                .build();
//    }
//
//    @Hidden
//    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
//    @ResponseStatus(NOT_FOUND)
//    public ExceptionResponse handleResourceNotFoundException(ResourceNotFoundException ResourceNotFoundException) {
//        return ExceptionResponse.builder()
//                .message(ResourceNotFoundException.getMessage())
//                .code("404")
//                .timestamp(now())
//                .build();
//    }
//
//    @Hidden
//    @org.springframework.web.bind.annotation.ExceptionHandler(SubscriptionExpiredException.class)
//    @ResponseStatus(NOT_FOUND)
//    public ExceptionResponse handleSubscriptionExpired(SubscriptionExpiredException SubscriptionExpiredException) {
//        return ExceptionResponse.builder()
//                .message(SubscriptionExpiredException.getMessage())
//                .code("403")
//                .timestamp(now())
//                .build();
//    }
//
//}


