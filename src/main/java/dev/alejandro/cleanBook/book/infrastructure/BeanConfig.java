package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.application.ListBooksOutputPort;
import dev.alejandro.cleanBook.book.application.ListBooksService;
import dev.alejandro.cleanBook.book.application.RegisterNewBookOutputPort;
import dev.alejandro.cleanBook.book.application.RegisterNewBookService;
import dev.alejandro.cleanBook.book.domain.BookExistenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    RegisterNewBookService registerNewBookService(
            RegisterNewBookOutputPort registerNewBookOutputPort,
            BookExistenceService bookExistenceService) {
        return new RegisterNewBookService(registerNewBookOutputPort, bookExistenceService);
    }

    @Bean
    ListBooksService listBooksService(ListBooksOutputPort listBooksOutputPort) {
        return new ListBooksService(listBooksOutputPort);
    }

}
