package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Compra;
import pe.edu.upeu.syscenterlife.repositorio.CompraRepository;

@Service
public class CompraService {
    @Autowired
    CompraRepository repository;
    
    //C
    public Compra guardarEntidad(Compra compra){
        return repository.save(compra);
    }
    
    //R
    public List<Compra> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Compra actualizarEntidad(Compra compra){
        return repository.save(compra);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Compra buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
