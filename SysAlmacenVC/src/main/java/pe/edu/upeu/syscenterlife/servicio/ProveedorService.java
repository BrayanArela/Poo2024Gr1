package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Proveedor;
import pe.edu.upeu.syscenterlife.repositorio.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    ProveedorRepository repository;
    
    // Crear
    public Proveedor guardarEntidad(Proveedor proveedor){
        return repository.save(proveedor);
    }
    
    // Leer todos los elementos
    public List<Proveedor> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Proveedor actualizarEntidad(Proveedor proveedor){
        return repository.save(proveedor);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Proveedor buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
