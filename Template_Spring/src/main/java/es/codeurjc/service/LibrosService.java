package es.codeurjc.service;

import es.codeurjc.model.Libro;
import es.codeurjc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrosService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibrosService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro updateLibro(Long id, Libro libroDetails) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroDetails.getTitulo());
            libro.setAutor(libroDetails.getAutor());
            libro.setAnioPublicacion(libroDetails.getAnioPublicacion());
            libro.setPuntoRecogida(libroDetails.getPuntoRecogida());
            return libroRepository.save(libro);
        }).orElse(null);
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }
}

