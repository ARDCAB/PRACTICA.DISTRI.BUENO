package es.codeurjc.repository;

import es.codeurjc.model.CodigoPostalMadrid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodigoPostalMadridRepository extends JpaRepository<CodigoPostalMadrid, String> {
    // Puedes agregar métodos personalizados si los necesitas
}
