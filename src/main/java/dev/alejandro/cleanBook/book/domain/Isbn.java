package dev.alejandro.cleanBook.book.domain;

public record Isbn(String isbn) {
    public Isbn {
        if(FieldValidator.stringIsBlank(isbn)) {
            throw new AttributeMalformedException("Isbn is required");
        }
    }
}
