package es.codeurjc.service;

import java.util.*;
import es.codeurjc.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private Map<Integer, Book> books = new HashMap<>();
    private int currentId = 1;  // Este contador genera un ID único para cada libro

    // Obtener todos los libros
    public List<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    // Obtener un libro por su ID
    public Book getById(int id) {
        return books.get(id);
    }

    // Crear un nuevo libro
    public Book create(Book book) {
        if (book != null && book.getTitulo() != null && book.getAutor() != null) {
            book.setId(currentId++);
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }

    // Actualizar un libro
    public Book update(int id, Book book) {
        if (books.containsKey(id)) {
            book.setId(id);
            books.put(id, book);
            return book;
        }
        return null;
    }

    // Actualización parcial de un libro (PATCH)
    public Book patch(int id, Map<String, Object> updates) {
        Book book = books.get(id);
        if (book != null) {
            if (updates.containsKey("titulo")) {
                book.setTitulo((String) updates.get("titulo"));
            }
            if (updates.containsKey("autor")) {
                book.setAutor((String) updates.get("autor"));
            }
            if (updates.containsKey("userId")) {
                book.setUserId((Integer) updates.get("userId"));
            }
            return book;
        }
        return null;  // Si el libro no existe, retornamos null
    }

    // Eliminar un libro por su ID
    public boolean delete(int id) {
        return books.remove(id) != null;
    }

    // Obtener todos los libros (método adicional)
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }



    // Agregar un libro (método adicional)
    public Book addBook(Book book) {
        book.setId(currentId++);
        books.put(book.getId(), book);
        System.out.println("Libro añadido: " + book.getId());
        return book;
    }
}
