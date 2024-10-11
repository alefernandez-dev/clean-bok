package dev.alejandro.cleanBook.book.domain;

public class AttributeMalformedException extends RuntimeException{
    public AttributeMalformedException(String message) {
        super(message);
    }
}
