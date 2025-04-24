/*package es.codeurjc.model;

import javax.persistence.Id;

public class Book {
    private int id;
    private String titulo;
    private String autor;
    private int userId; // ID del dueño (User)
    private String genre;

    public Book() {
    }

    public Book(int id, String titulo, String autor, int userId, String genre) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.userId = userId;
        this.genre = genre;
    }

    public Book(String titulo, String autor) {
        this.id = 0; // Asignar un valor predeterminado, el id se puede establecer más tarde.
        this.titulo = titulo;
        this.autor = autor;
        this.userId = 0; // Asignar un valor predeterminado para userId
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}*/
package es.codeurjc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String autor;
    private int userId;
    private String genre;

    public Book() {}

    public Book(int id, String titulo, String autor, int userId, String genre) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.userId = userId;
        this.genre = genre;
    }

    public Book(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

