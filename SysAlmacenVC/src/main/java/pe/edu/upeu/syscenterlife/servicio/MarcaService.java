package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Marca;
import pe.edu.upeu.syscenterlife.repositorio.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository repository;
    
    // Crear
    public Marca guardarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    // Leer todos los elementos
    public List<Marca> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Marca actualizarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Marca buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
