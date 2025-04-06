package es.codeurjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import es.codeurjc.model.Book;
import es.codeurjc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // REST API - Get all books (for REST calls)
    @GetMapping("/api")
    @ResponseBody
    public List<Book> getAll() {
        return bookService.getAll();
    }

    // REST API - Get a book by ID (for REST calls)
    @GetMapping("/api/{id}")
    @ResponseBody
    public Book getByIdApi(@PathVariable int id) {
        return bookService.getById(id);
    }

    // REST API - Create a book (for REST calls)
    @PostMapping("/api")
    @ResponseBody
    public Book createApi(@RequestBody Book book) {
        return bookService.create(book);
    }

    // REST API - Update a book (for REST calls)
    @PutMapping("/api/{id}")
    @ResponseBody
    public Book updateApi(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    // REST API - Partially update a book (for REST calls)
    @PatchMapping("/api/{id}")
    @ResponseBody
    public Book patchApi(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return bookService.patch(id, updates);
    }

    // REST API - Delete a book (for REST calls)
    @DeleteMapping("/api/{id}")
    @ResponseBody
    public void deleteApi(@PathVariable int id) {
        bookService.delete(id);
    }

    // Show the books page when accessing /books
    @GetMapping("")
    public String showBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();  // Get the list of books
        model.addAttribute("books", books);  // Add the list of books to the model
        return "books";  // This is the Thymeleaf template "books.html"
    }

    // Show the list of books in the /books/list view
    @GetMapping("/list")
    public String showBooksListPage(Model model) {
        List<Book> books = bookService.getAllBooks();  // Get the list of books
        model.addAttribute("books", books);  // Add the list of books to the model
        return "books";  // This is the Thymeleaf template "books.html"
    }

    // Create a new book from the form
    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String author) {
        Book newBook = new Book(title, author);  // Create a new book
        bookService.addBook(newBook);  // Add the book to the service
        return "redirect:/books/list";  // Redirect to the list of books
    }

    // Load the page to add a new book
    @GetMapping("/add")
    public String showAddBookForm() {
        return "add-book";  // This is the Thymeleaf template "add-book.html"
    }

    // Method to delete a book
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.delete(id); // Delete the book from the service
        return "redirect:/books/list"; // Redirect back to the list of books
    }

}

