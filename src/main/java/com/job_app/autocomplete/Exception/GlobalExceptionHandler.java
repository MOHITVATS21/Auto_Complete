package com.job_app.autocomplete.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResultFoundException.class)
    public ResponseEntity<String> handleNoResultFound(NoResultFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    @ExceptionHandler(PrefixCannotbenull.class)
    public ResponseEntity<String> handlePrefixCannotBeNull(PrefixCannotbenull ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    // Optional: catch-all
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body("Something went wrong: " + ex.getMessage());
//    }
}

