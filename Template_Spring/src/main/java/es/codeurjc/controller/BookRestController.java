package es.codeurjc.controller;

import es.codeurjc.model.Book;
import es.codeurjc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    // Obtener todos los libros
    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    // Crear un nuevo libro
    @PostMapping
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    // Actualizar un libro completo
    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    // Actualizar parcialmente un libro
    @PatchMapping("/{id}")
    public Book patch(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return bookService.patch(id, updates);
    }

    // Eliminar un libro
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}

