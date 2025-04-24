package es.codeurjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.codeurjc.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    // Puedes agregar métodos personalizados si lo necesitas más adelante
}

