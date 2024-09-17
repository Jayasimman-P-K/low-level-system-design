package LibraryManagement.Services;

import java.util.HashMap;
import java.util.Map;

import LibraryManagement.Models.Book;

public class BookService {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }
}
