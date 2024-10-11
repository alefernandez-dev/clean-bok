package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.domain.Book;
import dev.alejandro.cleanBook.book.domain.BookIsbnAlreadyExistsException;
import dev.alejandro.cleanBook.book.domain.BookExistenceService;
import org.springframework.stereotype.Component;

@Component
public class BookExistenceServiceAdapter implements BookExistenceService {

    private final BookJpaRepository bookJpaRepository;

    public BookExistenceServiceAdapter(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public void verifyNoDuplicate(Book book) throws BookIsbnAlreadyExistsException {

        var isbn = book.isbn().isbn();

        if (this.bookJpaRepository.existsById(isbn)) {
            throw new BookIsbnAlreadyExistsException("Isbn: " + isbn + " already exists");
        }

    }
}
