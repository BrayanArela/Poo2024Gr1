
package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Marca;
import pe.edu.upeu.syscenterlife.repositorio.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository repository;
    
    //C
    public Marca guardarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    //R
    public List<Marca> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Marca actualizarEntidad(Marca marca){
        return repository.save(marca);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Marca buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}