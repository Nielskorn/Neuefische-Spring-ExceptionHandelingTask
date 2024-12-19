package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NoSuchElementException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public String handleNoSuchElementException(NoSuchElementException e) {
//        return e.getMessage()+" from Global Exception with Love";
//    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleNoSuchElementException(NoSuchElementException e) {
        return  new ErrorMessage(e.getMessage(), Instant.now(), UUID.randomUUID().toString());
    }
}
