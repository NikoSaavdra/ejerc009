package es.santander.ascender.ejerc009.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc009.Repository.PersonaRepository;
import es.santander.ascender.ejerc009.model.Persona;

@Service
@Transactional
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona createPersona(Persona persona) {
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
