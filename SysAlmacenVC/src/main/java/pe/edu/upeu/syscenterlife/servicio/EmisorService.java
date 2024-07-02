package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Emisor;
import pe.edu.upeu.syscenterlife.repositorio.EmisorRepository;

@Service
public class EmisorService {
    @Autowired
    EmisorRepository repository;
    
    // Crear
    public Emisor guardarEntidad(Emisor emisor){
        return repository.save(emisor);
    }
    
    // Leer todos los elementos
    public List<Emisor> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Emisor actualizarEntidad(Emisor emisor){
        return repository.save(emisor);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Emisor buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
