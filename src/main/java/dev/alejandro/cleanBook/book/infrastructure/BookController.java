package dev.alejandro.cleanBook.book.infrastructure;

import dev.alejandro.cleanBook.book.application.BookApplicationData;
import dev.alejandro.cleanBook.book.application.ListBooksService;
import dev.alejandro.cleanBook.book.application.RegisterNewBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final RegisterNewBookService registerNewBookService;
    private final ListBooksService listBooksService;


    public BookController(RegisterNewBookService registerNewBookService, ListBooksService listBooksService) {
        this.registerNewBookService = registerNewBookService;
        this.listBooksService = listBooksService;
    }


    @PostMapping
    ResponseEntity<Response<String>> register(@RequestBody BookApplicationData bookApplicationData) {
        this.registerNewBookService.register(bookApplicationData);
        var response = Response.success(HttpStatus.CREATED.value(), "Book created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    ResponseEntity<Response<List<BookApplicationData>>> list(@RequestParam(required = false, defaultValue = "20") int limit) {
        var books = listBooksService.list(limit);
        var response = Response.success(HttpStatus.OK.value(), books);
        return ResponseEntity.ok(response);
    }

}
