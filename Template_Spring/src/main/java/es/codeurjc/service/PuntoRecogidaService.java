package es.codeurjc.service;

import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.repository.PuntoRecogidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PuntoRecogidaService {

    @Autowired
    private PuntoRecogidaRepository puntoRepo;

    public List<PuntoRecogida> getAll() {
        return puntoRepo.findAll();
    }

    public PuntoRecogida create(PuntoRecogida punto) {
        return puntoRepo.save(punto);
    }

    public void addPunto(PuntoRecogida punto) {
        puntoRepo.save(punto);
    }

    public List<PuntoRecogida> getByPostalCode(String codigoPostal) {
        return puntoRepo.findByCodigoPostal_Codigo(codigoPostal);
    }

    public PuntoRecogida getById(int id) {
        return puntoRepo.findById(id).orElse(null);
    }

    public void update(int id, PuntoRecogida updated) {
        updated.setId(id);
        puntoRepo.save(updated);
    }

    public PuntoRecogida patch(int id, Map<String, Object> updates) {
        Optional<PuntoRecogida> optional = puntoRepo.findById(id);
        if (optional.isEmpty()) return null;

        PuntoRecogida punto = optional.get();

        if (updates.containsKey("userId")) {
            punto.setUserId((int) updates.get("userId"));
        }

        // Agrega aquí más campos si necesitas actualizarlos

        return puntoRepo.save(punto);
    }

    public void delete(int id) {
        puntoRepo.deleteById(id);
    }
}


