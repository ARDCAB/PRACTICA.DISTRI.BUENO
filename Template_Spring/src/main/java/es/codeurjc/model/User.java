package es.codeurjc.model;

public class User {
 private int id;
 private String nombre;
 private String email;
 private String password;  // Campo para la contraseña

 // Constructor por defecto
 public User() {}

 // Constructor con parámetros
 public User(int id, String nombre, String email, String password) {
  this.id = id;
  this.nombre = nombre;
  this.email = email;
  this.password = password;  // Inicializar la contraseña
 }

 // Getter y Setter para id
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 // Getter y Setter para nombre
 public String getNombre() {
  return nombre;
 }

 public void setNombre(String nombre) {
  this.nombre = nombre;
 }

 // Getter y Setter para email
 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 // Getter y Setter para password
 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }
}
