package dev.alejandro.cleanBook.book.domain;

public record Editorial(String editorialName) {
    public Editorial {
        if(FieldValidator.stringIsBlank(editorialName)) {
            throw new AttributeMalformedException("Editorial name is required");
        }
        if(FieldValidator.isStringLengthOutOfRange(editorialName, 6, 50)) {
            throw new AttributeMalformedException("Editorial name is out of range (min 6 chars, max 50 chars)");
        }
    }
}
