package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.CompCarrito;
import pe.edu.upeu.syscenterlife.repositorio.CompCarritoRepository;

@Service
public class CompCarritoService {
    @Autowired
    CompCarritoRepository repository;
    
    // Crear
    public CompCarrito guardarEntidad(CompCarrito compCarrito){
        return repository.save(compCarrito);
    }
    
    // Leer todos los elementos
    public List<CompCarrito> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public CompCarrito actualizarEntidad(CompCarrito compCarrito){
        return repository.save(compCarrito);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public CompCarrito buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
