package dev.alejandro.cleanBook.book.domain;

public interface BookExistenceService {
    void verifyNoDuplicate(Book book) throws BookIsbnAlreadyExistsException;
}
