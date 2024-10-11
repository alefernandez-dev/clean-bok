package dev.alejandro.cleanBook.book.application;

import dev.alejandro.cleanBook.book.domain.*;

public class RegisterNewBookService {

    private final RegisterNewBookOutputPort registerNewBookOutputPort;
    private final BookExistenceService bookExistenceService;

    public RegisterNewBookService(RegisterNewBookOutputPort registerNewBookOutputPort,
                                  BookExistenceService bookExistenceService) {
        this.registerNewBookOutputPort = registerNewBookOutputPort;
        this.bookExistenceService = bookExistenceService;
    }

    public void register(BookApplicationData bookInput) {

        var isbn = new Isbn(bookInput.isbn());
        var title = new Title(bookInput.title());
        var author = new Author(bookInput.author());
        var editorial = new Editorial(bookInput.editorial());

        var book = new Book(isbn, title, author, editorial);

        this.bookExistenceService.verifyNoDuplicate(book);

        this.registerNewBookOutputPort.save(book);

    }
}
