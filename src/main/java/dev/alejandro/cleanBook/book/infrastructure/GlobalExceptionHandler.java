package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.domain.AttributeMalformedException;
import dev.alejandro.cleanBook.book.domain.BookIsbnAlreadyExistsException;
import jakarta.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BookIsbnAlreadyExistsException.class)
    ResponseEntity<Response<String>> isbnExceptions() {
        var response = Response.error(HttpStatus.BAD_REQUEST.value(), "Isbn already exists");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(AttributeMalformedException.class)
    ResponseEntity<Response<String>> bookEntityExceptions(AttributeMalformedException e) {
        log.error(e.getMessage());
        var response = Response.error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ServletException.class)
    ResponseEntity<Void> appExceptions(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<Void> exceptions(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().build();
    }

}
