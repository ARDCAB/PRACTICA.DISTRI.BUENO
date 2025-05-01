package es.codeurjc.model;

import jakarta.persistence.*;

@Entity
public class PuntoRecogida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "codigo_postal", referencedColumnName = "codigo")
    private CodigoPostalMadrid codigoPostal;

    private int userId;

    public PuntoRecogida() {}

    public PuntoRecogida(CodigoPostalMadrid codigoPostal, int userId) {
        this.codigoPostal = codigoPostal;
        this.userId = userId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public CodigoPostalMadrid getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(CodigoPostalMadrid codigoPostal) { this.codigoPostal = codigoPostal; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}

