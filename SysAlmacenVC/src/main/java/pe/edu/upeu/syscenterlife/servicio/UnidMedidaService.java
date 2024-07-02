package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.UnidMedida;
import pe.edu.upeu.syscenterlife.repositorio.UnidMedidaRepository;

@Service
public class UnidMedidaService {
    @Autowired
    UnidMedidaRepository repository;
    
    // Crear
    public UnidMedida guardarEntidad(UnidMedida unidMedida){
        return repository.save(unidMedida);
    }
    
    // Leer todos los elementos
    public List<UnidMedida> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public UnidMedida actualizarEntidad(UnidMedida unidMedida){
        return repository.save(unidMedida);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public UnidMedida buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
