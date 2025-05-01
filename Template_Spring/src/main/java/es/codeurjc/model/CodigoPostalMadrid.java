package es.codeurjc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CodigoPostalMadrid {
    @Id
    private String codigo;  // Código postal como clave primaria
    private String direccion;

    public CodigoPostalMadrid() {}

    public CodigoPostalMadrid(String codigo, String direccion) {
        this.codigo = codigo;
        this.direccion = direccion;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
}
