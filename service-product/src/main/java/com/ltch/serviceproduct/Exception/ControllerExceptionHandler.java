package com.ltch.serviceproduct.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                  WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage().builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timestamp( new Date())
                .message(resourceNotFoundException.getMessage())
                .description(webRequest.getDescription(false)).build();
        return  ResponseEntity.status(errorMessage.getStatusCode())
                    .body(errorMessage);
    }

    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ErrorMessage> globalExceptionHandler(Exception exception, WebRequest webRequest){
        ErrorMessage errorMessage = new ErrorMessage().builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp( new Date())
                .message(exception.getMessage())
                .description(webRequest.getDescription(false)).build();
        return  ResponseEntity.status(errorMessage.getStatusCode())
                .body(errorMessage);
    }
}
