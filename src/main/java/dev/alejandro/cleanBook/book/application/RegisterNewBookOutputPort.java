package dev.alejandro.cleanBook.book.application;

import dev.alejandro.cleanBook.book.domain.Book;

public interface RegisterNewBookOutputPort {
    void save(Book book);
}
