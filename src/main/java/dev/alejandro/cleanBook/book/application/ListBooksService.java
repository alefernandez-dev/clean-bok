package dev.alejandro.cleanBook.book.application;

import dev.alejandro.cleanBook.book.domain.Book;

import java.util.List;

public class ListBooksService {

    private final ListBooksOutputPort listBooksOutputPort;

    public ListBooksService(ListBooksOutputPort listBooksOutputPort) {
        this.listBooksOutputPort = listBooksOutputPort;
    }

    public List<BookApplicationData> list(int limit) {
        return this.listBooksOutputPort.list(limit)
                .stream()
                .map(this::toBook)
                .toList();
    }

    private BookApplicationData toBook(Book book) {
        return new BookApplicationData(
                book.isbn().isbn(),
                book.title().title(),
                book.author().authorFullName(),
                book.editorial().editorialName()
        );
    }
}
