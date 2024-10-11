package dev.alejandro.cleanBook.book.domain;

public record Book (
        Isbn isbn,
        Title title,
        Author author,
        Editorial editorial
) {

    public Book {
        if (FieldValidator.isNull(isbn)) throw new AttributeMalformedException("isbn must not ne null");
        if (FieldValidator.isNull(title)) throw new AttributeMalformedException("title must not be null");
        if (FieldValidator.isNull(author)) throw new AttributeMalformedException("author must not be null");
        if (FieldValidator.isNull(editorial)) throw new AttributeMalformedException("editorial must not be null");
    }

}