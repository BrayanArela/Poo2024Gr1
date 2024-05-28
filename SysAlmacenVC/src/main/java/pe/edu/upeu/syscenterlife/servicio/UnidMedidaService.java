package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.UnidMedida;
import pe.edu.upeu.syscenterlife.repositorio.UnidMedidaRepository;

@Service
public class UnidMedidaService {
    @Autowired
    UnidMedidaRepository repository;
    
    //C
    public UnidMedida guardarEntidad(UnidMedida unidMedida){
        return repository.save(unidMedida);
    }
    
    //R
    public List<UnidMedida> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public UnidMedida actualizarEntidad(UnidMedida unidMedida){
        return repository.save(unidMedida);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public UnidMedida buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}