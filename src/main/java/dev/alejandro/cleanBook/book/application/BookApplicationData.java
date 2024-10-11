package dev.alejandro.cleanBook.book.application;

import java.io.Serializable;

public record BookApplicationData(
        String isbn,
        String title,
        String author,
        String editorial) implements Serializable {
}
