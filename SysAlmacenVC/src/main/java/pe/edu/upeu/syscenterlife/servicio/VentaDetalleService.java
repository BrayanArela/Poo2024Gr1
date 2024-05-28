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
    
    //C
    public VentaDetalle guardarEntidad(VentaDetalle ventaDetalle){
        return repository.save(ventaDetalle);
    }
    
    //R
    public List<VentaDetalle> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public VentaDetalle actualizarEntidad(VentaDetalle ventaDetalle){
        return repository.save(ventaDetalle);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public VentaDetalle buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
