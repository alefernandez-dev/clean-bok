package dev.alejandro.cleanBook.book.domain;

public record Author(String authorFullName) {
    public Author {
        if(FieldValidator.stringIsBlank(authorFullName)) {
            throw new AttributeMalformedException("Author fullName is required");
        }
        if(FieldValidator.isStringLengthOutOfRange(authorFullName, 6, 50)) {
            throw new AttributeMalformedException("Author fullName is out of range (min 6 chars, max 50 chars)");
        }
    }
}
