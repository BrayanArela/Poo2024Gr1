package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.VentaDetalle;
import pe.edu.upeu.syscenterlife.repositorio.VentaDetalleRepository;

@Service
public class VentaDetalleService {
    @Autowired
    VentaDetalleRepository repository;
    
    // Crear
    public VentaDetalle guardarEntidad(VentaDetalle ventaDetalle){
        return repository.save(ventaDetalle);
    }
    
    // Leer todos los elementos
    public List<VentaDetalle> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public VentaDetalle actualizarEntidad(VentaDetalle ventaDetalle){
        return repository.save(ventaDetalle);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public VentaDetalle buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
