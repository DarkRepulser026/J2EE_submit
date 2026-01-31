package com.example.demo.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Service.BookService;
import com.example.demo.Model.Book;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("")
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all books (API)
    @GetMapping("/api/books")
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get a book by ID (API)
    @GetMapping("/api/books/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // Add a new book (API)
    @PostMapping("/api/books")
    @ResponseBody
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Book added successfully";
    }

    // Update a book (API)
    @PutMapping("/api/books/{id}")
    @ResponseBody
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        bookService.updateBook(id, book);
        return "Book updated successfully";
    }

    // Delete a book (API)
    @DeleteMapping("/api/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }

    // =====================
    // Web Page Endpoints
    // =====================
    // Show all books (web page)
    @GetMapping("/books")
    public String booksPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    // Show add book form (web page)
    @GetMapping("/add-book")
    public String addBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // Handle add book form submission (web page)
    @PostMapping("/add-book")
    public String handleAddBook(Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    // Show edit book form (web page)
    @GetMapping("/edit-book/{id}")
    public String editBookPage(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    // Handle edit book form submission (web page)
    @PostMapping("/edit-book/{id}")
    public String handleEditBook(@PathVariable int id, Book book) {
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    // Handle delete book form submission (web page)
    @PostMapping("/api/books/{id}")
    public String handleDeleteBook(@PathVariable int id, org.springframework.web.context.request.WebRequest request) {
        String method = request.getParameter("_method");
        if (method != null && method.equalsIgnoreCase("delete")) {
            bookService.deleteBook(id);
        }
        return "redirect:/books";
    }

    // Show about page (web page)
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
