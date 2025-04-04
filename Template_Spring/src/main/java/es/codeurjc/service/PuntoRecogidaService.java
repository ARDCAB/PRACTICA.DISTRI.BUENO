package es.codeurjc.service;

import es.codeurjc.model.PuntoRecogida;
import es.codeurjc.repository.PuntoRecogidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntoRecogidaService {

    private final PuntoRecogidaRepository puntoRecogidaRepository;

    @Autowired
    public PuntoRecogidaService(PuntoRecogidaRepository puntoRecogidaRepository) {
        this.puntoRecogidaRepository = puntoRecogidaRepository;
    }

    public List<PuntoRecogida> getAllPuntosRecogida() {
        return puntoRecogidaRepository.findAll();
    }

    public PuntoRecogida getPuntoRecogidaById(Long id) {
        return puntoRecogidaRepository.findById(id).orElse(null);
    }

    public PuntoRecogida createPuntoRecogida(PuntoRecogida puntoRecogida) {
        return puntoRecogidaRepository.save(puntoRecogida);
    }

    public PuntoRecogida updatePuntoRecogida(Long id, PuntoRecogida puntoRecogidaDetails) {
        return puntoRecogidaRepository.findById(id).map(puntoRecogida -> {
            puntoRecogida.setDireccion(puntoRecogidaDetails.getDireccion());
            puntoRecogida.setCiudad(puntoRecogidaDetails.getCiudad());
            return puntoRecogidaRepository.save(puntoRecogida);
        }).orElse(null);
    }

    public void deletePuntoRecogida(Long id) {
        puntoRecogidaRepository.deleteById(id);
    }
}

