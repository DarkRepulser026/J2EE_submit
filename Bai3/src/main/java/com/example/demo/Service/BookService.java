package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.Model.Book;
import java.util.ArrayList;
import java.util.List;

@Service

public class BookService {
    // In-memory list of books
    private final List<Book> books = new ArrayList<>();
    private int nextId = 1;

    // Initialize with some sample books for testing
    public BookService() {
        addBook(new Book(0, "The Great Gatsby", "F. Scott Fitzgerald"));
        addBook(new Book(0, "To Kill a Mockingbird", "Harper Lee"));
        addBook(new Book(0, "1984", "George Orwell"));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Get a book by its ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Add a new book (auto-increment ID)
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    // Update an existing book by ID
    public void updateBook(int id, Book updateBook) {
        books.stream()
            .filter(book -> book.getId() == id)
            .findFirst()
            .ifPresent(book -> {
                book.setTitle(updateBook.getTitle());
                book.setAuthor(updateBook.getAuthor());
            });
    }

    // Delete a book by ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}
