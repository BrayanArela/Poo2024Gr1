package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Emisor;
import pe.edu.upeu.syscenterlife.repositorio.EmisorRepository;

@Service
public class EmisorService {
    @Autowired
    EmisorRepository repository;
    
    //C
    public Emisor guardarEntidad(Emisor emisor){
        return repository.save(emisor);
    }
    
    //R
    public List<Emisor> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Emisor actualizarEntidad(Emisor emisor){
        return repository.save(emisor);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Emisor buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
