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

    // Método para obtener todos los libros, usado para la API REST
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    // Método para obtener un libro por ID, usado para la API REST
    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book create(@RequestParam Book book) {
        return bookService.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @PatchMapping("/{id}")
    public Book patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return bookService.patch(id, updates);
    }

    // Método para eliminar un libro, usado para la API REST
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

    // Mostrar la lista de libros en la vista
    @GetMapping("/list")
    public String showBooksPage(Model model) {
        List<Book> books = bookService.getAllBooks();
        return "books";
    }

    // Manejar la creación de nuevos libros desde un formulario
    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam String author) {
        Book newBook = new Book(title, author); // Crear un nuevo libro
        bookService.addBook(newBook); // Agregar el libro al servicio
        return "redirect:/books/list"; // Redirigir a la lista de libros
    }

    // Método para cargar la página de agregar libro
    @GetMapping("/add")
    public String showAddBookForm() {
        return "add-book";
    }
}

