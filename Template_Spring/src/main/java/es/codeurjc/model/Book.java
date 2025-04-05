package es.codeurjc.model;

public class Book {
    private int id;
    private String titulo;
    private String autor;
    private int userId; // ID del dueño (User)

    public Book() {
    }

    public Book(int id, String titulo, String autor, int userId) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.userId = userId;
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
}
