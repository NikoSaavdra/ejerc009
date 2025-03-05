package es.santander.ascender.ejerc008.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;

@RestController
@RequestMapping("/api/persona")

public class PersonaController {

    @Autowired
   private PersonaService personaService;

   // Create
   @PostMapping
   public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
       persona.getProvincia().forEach(d -> d.setProvincia(provincia));
       Provincia createdProvincia= provinciaService.createProvincia(provincia);

       return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
   }

   // Read (all)
   @GetMapping
   public ResponseEntity<List<Persona>> getAllPersonas() {
       List<Persona> personas = personaService.getAllPersonas();
       return new ResponseEntity<>(personas, HttpStatus.OK);
   }

   // Read (by ID)
   @GetMapping("/{id}")
   public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
       Optional<Persona> persona = personaService.getPersonaById(id);
       if (persona.isPresent()) {
           return new ResponseEntity<>(provincia.get(), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   // Update
   @PutMapping("/{id}")
   public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
              
       Provincia updatedPersona = personaService.updatePersona(id, personaDetails);
       if (updatedPersona != null) {
           return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   
}
