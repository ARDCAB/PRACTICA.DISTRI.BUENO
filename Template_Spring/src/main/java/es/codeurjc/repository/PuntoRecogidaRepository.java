package es.codeurjc.repository;

import es.codeurjc.model.PuntoRecogida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuntoRecogidaRepository extends JpaRepository<PuntoRecogida, Integer> {
    List<PuntoRecogida> findByCodigoPostal_Codigo(String codigoPostal);
}

