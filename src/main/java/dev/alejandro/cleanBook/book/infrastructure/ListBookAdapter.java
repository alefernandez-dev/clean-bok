package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.application.ListBooksOutputPort;
import dev.alejandro.cleanBook.book.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListBookAdapter implements ListBooksOutputPort {

    private final BookJpaRepository bookJpaRepository;

    public ListBookAdapter(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public List<Book> list(int limit) {
        return bookJpaRepository
                .findAll()
                .stream()
                .map(this::toBook)
                .toList();
    }

    private Book toBook(BookJpa bookJpa) {
        var isbn = new Isbn(bookJpa.getIsbn());
        var title = new Title(bookJpa.getTitle());
        var author = new Author(bookJpa.getAuthor());
        var editorial = new Editorial(bookJpa.getEditorial());

        return new Book(isbn, title, author, editorial);
    }
}
