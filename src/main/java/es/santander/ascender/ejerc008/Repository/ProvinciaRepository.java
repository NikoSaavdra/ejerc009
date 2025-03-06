package es.santander.ascender.ejerc008.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc008.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
    Optional<Provincia> findByNombre(String nombre);

}

