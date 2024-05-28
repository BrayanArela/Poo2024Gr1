package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.VentCarrito;
import pe.edu.upeu.syscenterlife.repositorio.VentCarritoRepository;

@Service
public class VentCarritoService {
    @Autowired
    VentCarritoRepository repository;
    
    //C
    public VentCarrito guardarEntidad(VentCarrito ventCarrito){
        return repository.save(ventCarrito);
    }
    
    //R
    public List<VentCarrito> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public VentCarrito actualizarEntidad(VentCarrito ventCarrito){
        return repository.save(ventCarrito);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public VentCarrito buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
