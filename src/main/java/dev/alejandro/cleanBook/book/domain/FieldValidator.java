package dev.alejandro.cleanBook.book.domain;

public final class FieldValidator {

    private FieldValidator() {
    }

    public static boolean stringIsBlank(String str) {
        if (str == null) {
            return true;
        }
        return str.isBlank();
    }

    public static<T> boolean isNull(T value) {
        return value == null;
    }

    public static boolean isStringLengthOutOfRange(String str, int minLength, int maxLength) {
        if (str == null) {
            return true;
        }
        return str.length() <= minLength || str.length() >= maxLength;
    }

}
