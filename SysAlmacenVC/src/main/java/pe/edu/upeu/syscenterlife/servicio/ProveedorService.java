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
    
    //C
    public Proveedor guardarEntidad(Proveedor proveedor){
        return repository.save(proveedor);
    }
    
    //R
    public List<Proveedor> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Proveedor actualizarEntidad(Proveedor proveedor){
        return repository.save(proveedor);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Proveedor buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
