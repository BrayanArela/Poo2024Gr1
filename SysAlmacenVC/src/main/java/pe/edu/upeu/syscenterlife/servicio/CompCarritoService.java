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
    
    //C
    public CompCarrito guardarEntidad(CompCarrito compCarrito){
        return repository.save(compCarrito);
    }
    
    //R
    public List<CompCarrito> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public CompCarrito actualizarEntidad(CompCarrito compCarrito){
        return repository.save(compCarrito);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public CompCarrito buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
