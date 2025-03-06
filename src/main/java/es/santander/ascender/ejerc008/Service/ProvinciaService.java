package es.santander.ascender.ejerc008.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.Repository.ProvinciaRepository;
import es.santander.ascender.ejerc008.model.Provincia;

@Service
@Transactional
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Provincia createProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    public Provincia updateProvincia(Long id, Provincia provinciaDetails) {
        Optional<Provincia> provinciaOptional = provinciaRepository.findById(id);
        if (provinciaOptional.isPresent()) {
            Provincia provincia = provinciaOptional.get();
            provincia.setNombre(provinciaDetails.getNombre());
            return provinciaRepository.save(provincia);
        }
        return null;
    }

    public Optional<Provincia> getProvinciaByName(String nombre) {
        // Aquí realizas la lógica para buscar la provincia por su nombre
        return provinciaRepository.findByNombre(nombre);
    }
    
    
}
