package es.codeurjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.codeurjc.model.PuntoRecogida;

import java.util.List;

public interface PuntoRecogidaRepository extends JpaRepository<PuntoRecogida, Integer> {
    List<PuntoRecogida> findByCodigoPostal_Codigo(String codigoPostal);
}
