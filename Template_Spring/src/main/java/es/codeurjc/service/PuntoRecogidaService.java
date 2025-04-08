package es.codeurjc.service;

import es.codeurjc.model.Book;
import es.codeurjc.model.PuntoRecogida;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PuntoRecogidaService {
    private Map<Integer, PuntoRecogida> puntos = new HashMap<>();
    private int currentId = 1;

    public List<PuntoRecogida> getAll() {
        return new ArrayList<>(puntos.values());
    }

    public PuntoRecogida getById(int id) {
        return puntos.get(id);
    }

    public PuntoRecogida create(PuntoRecogida punto) {
        punto.setId(currentId++);
        puntos.put(punto.getId(), punto);
        return punto;
    }

    public PuntoRecogida update(int id, PuntoRecogida punto) {
        if (puntos.containsKey(id)) {
            punto.setId(id);
            puntos.put(id, punto);
            return punto;
        }
        return null;
    }

    public PuntoRecogida patch(int id, Map<String, Object> updates) {
        PuntoRecogida punto = puntos.get(id);
        if (punto != null) {
            if (updates.containsKey("direccion")) {
                punto.setDireccion((String) updates.get("direccion"));
            }
            if (updates.containsKey("ciudad")) {
                punto.setCiudad((String) updates.get("ciudad"));
            }
            if (updates.containsKey("userId")) {
                punto.setUserId((Integer) updates.get("userId"));
            }
        }
        return punto;
    }

    // Agregar un libro (método adicional)
    public PuntoRecogida addPunto(PuntoRecogida p) {
        p.setId(currentId++);
        puntos.put(p.getId(), p);
        System.out.println("Punto Recogida añadido: " + p.getId());
        return p;
    }

    public boolean delete(int id) {
        return puntos.remove(id) != null;
    }
}


