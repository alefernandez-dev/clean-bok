package dev.alejandro.cleanBook.book.infrastructure;

import java.io.Serializable;

public record Response<T>(
        boolean success,
        boolean error,
        int code,
        T data) implements Serializable {

    public static <T> Response<T> success(int code, T data) {
        return new Response<>(true, false, code, data);
    }

    public static <T> Response<T> error(int code, T data) {
        return new Response<>(false, true, code, data);
    }
}
