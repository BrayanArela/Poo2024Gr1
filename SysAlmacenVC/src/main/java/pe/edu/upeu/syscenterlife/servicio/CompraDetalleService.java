package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.CompraDetalle;
import pe.edu.upeu.syscenterlife.repositorio.CompraDetalleRepository;

@Service
public class CompraDetalleService {
    @Autowired
    CompraDetalleRepository repository;
    
    // Crear
    public CompraDetalle guardarEntidad(CompraDetalle compraDetalle){
        return repository.save(compraDetalle);
    }
    
    // Leer todos los elementos
    public List<CompraDetalle> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public CompraDetalle actualizarEntidad(CompraDetalle compraDetalle){
        return repository.save(compraDetalle);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public CompraDetalle buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
