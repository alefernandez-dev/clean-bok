package dev.alejandro.cleanBook.book.domain;

public record Title(String title) {
    public Title {
        if(FieldValidator.stringIsBlank(title)) {
            throw new AttributeMalformedException("Title is required");
        }
        if(FieldValidator.isStringLengthOutOfRange(title, 6, 50)) {
            throw new AttributeMalformedException("Title is out of range (min 6 chars, max 50 chars)");
        }
    }
}
