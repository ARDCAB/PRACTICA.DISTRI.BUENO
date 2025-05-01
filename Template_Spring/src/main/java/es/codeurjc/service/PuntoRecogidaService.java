package es.codeurjc.service;

import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.repository.PuntoRecogidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoRecogidaService {

    @Autowired
    private PuntoRecogidaRepository repository;

    // Obtener todos los puntos disponibles
    public List<PuntoRecogida> getAll() {
        return repository.findAll();
    }

    // Obtener punto por ID
    public PuntoRecogida getById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Buscar puntos por código postal
    public List<PuntoRecogida> getByCodigoPostal(String codigoPostal) {
        return repository.findByCodigoPostal(codigoPostal);
    }
}


