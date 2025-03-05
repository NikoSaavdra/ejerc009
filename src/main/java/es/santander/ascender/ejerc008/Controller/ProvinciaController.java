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

import es.santander.ascender.ejerc008.Service.PersonaService;
import es.santander.ascender.ejerc008.Service.ProvinciaService;
import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private PersonaService personaService;

    // Create
    @PostMapping
    public ResponseEntity<Provincia> createProvincia(@RequestBody Provincia provincia) {
        Provincia createdProvincia = provinciaService.createProvincia(provincia);
        return new ResponseEntity<>(createdProvincia, HttpStatus.CREATED);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Provincia>> getAllProvincias() {
        List<Provincia> provincias = provinciaService.getAllProvincias();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> getProvinciaById(@PathVariable Long id) {
        Optional<Provincia> provincia = provinciaService.getProvinciaById(id);
        if (provincia.isPresent()) {
            return new ResponseEntity<>(provincia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Provincia> updateProvincia(@PathVariable Long id, @RequestBody Provincia provinciaDetails) {
        Provincia updatedProvincia = provinciaService.updateProvincia(id, provinciaDetails);
        if (updatedProvincia != null) {
            return new ResponseEntity<>(updatedProvincia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener personas de una provincia específica
    @GetMapping("/{id}/personas")
    public ResponseEntity<List<Persona>> getPersonasByProvincia(@PathVariable Long id) {
        List<Persona> personas = personaService.getPersonasByProvincia(id);
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
}
