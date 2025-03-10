package es.santander.ascender.ejerc009.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.classic.Logger;
import es.santander.ascender.ejerc009.model.Persona;
import es.santander.ascender.ejerc009.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {

    private static final Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(PersonaService.class);

    @Autowired
    private PersonaRepository personaRepository;

    public Persona createPersona(Persona persona) {
        logger.info(String.format("La fecha actual: %s", LocalDateTime.now()));
        return personaRepository.save(persona);
    }

    @Transactional(readOnly = true)
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Persona> getPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona updatePersona(Long id, Persona personaDetails) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            persona.setNombre(personaDetails.getNombre());
            persona.setApellidos(personaDetails.getApellidos());
            persona.setFechaNacimiento(personaDetails.getFechaNacimiento());
            persona.setTelefono(personaDetails.getTelefono());
            return personaRepository.save(persona);
        }
        return null;
    }

    public boolean deletePersona(Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
