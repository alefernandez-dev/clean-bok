package dev.alejandro.cleanBook.book.application;

import dev.alejandro.cleanBook.book.domain.Book;

import java.util.List;

public interface ListBooksOutputPort {
    List<Book> list(int limit);
}
