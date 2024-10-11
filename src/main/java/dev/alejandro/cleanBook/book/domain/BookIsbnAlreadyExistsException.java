package dev.alejandro.cleanBook.book.domain;

public class BookIsbnAlreadyExistsException extends RuntimeException{
    public BookIsbnAlreadyExistsException(String message) {
        super(message);
    }
}
