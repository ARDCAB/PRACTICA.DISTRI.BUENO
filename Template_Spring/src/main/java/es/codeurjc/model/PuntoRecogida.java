package es.codeurjc.model;

public class PuntoRecogida {
    private int id;
    private String direccion;
    private String ciudad;
    private int userId; // ID del usuario asociado

    public PuntoRecogida() {
    }

    public PuntoRecogida(int id, String direccion, String ciudad, int userId) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
