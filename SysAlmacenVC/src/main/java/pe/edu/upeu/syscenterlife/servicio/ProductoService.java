package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Producto;
import pe.edu.upeu.syscenterlife.repositorio.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository repository;
    
    //C
    public Producto guardarEntidad(Producto producto){
        return repository.save(producto);
    }
    
    //R
    public List<Producto> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Producto actualizarEntidad(Producto producto){
        return repository.save(producto);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Producto buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
