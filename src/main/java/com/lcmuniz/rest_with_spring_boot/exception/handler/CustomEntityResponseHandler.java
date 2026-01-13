package com.lcmuniz.rest_with_spring_boot.exception.handler;

import com.lcmuniz.rest_with_spring_boot.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(Exception.class)
        public final ResponseEntity<ExceptionResponse> exceptionHandler(Exception ex, WebRequest request) {
            ExceptionResponse response = new ExceptionResponse(
                    new Date(),
                    ex.getMessage(),
                    request.getDescription(false)
            );
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> unsupportedMathOperationExceptionHandler(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> fileNotFoundExceptionHandler(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ExceptionResponse> fileStorageExceptionHandler(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> invalidJwtAuthenticationExceptionHandler(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }


}
