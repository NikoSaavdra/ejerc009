package es.santander.ascender.ejerc008.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc008.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}

