package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.application.RegisterNewBookOutputPort;
import dev.alejandro.cleanBook.book.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class RegisterNewBookAdapter implements RegisterNewBookOutputPort {

    private final BookJpaRepository bookJpaRepository;

    public RegisterNewBookAdapter(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }


    @Override
    public void save(Book book) {

        this.bookJpaRepository.save(this.toJpaEntity(book));

    }

    private BookJpa toJpaEntity(Book book) {
        var bookJpa = new BookJpa();
        bookJpa.setIsbn(book.isbn().isbn());
        bookJpa.setTitle(book.title().title());
        bookJpa.setAuthor(book.author().authorFullName());
        bookJpa.setEditorial(book.editorial().editorialName());
        return bookJpa;

    }
}
