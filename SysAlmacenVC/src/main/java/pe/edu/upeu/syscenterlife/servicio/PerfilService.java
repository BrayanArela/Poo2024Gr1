package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Perfil;
import pe.edu.upeu.syscenterlife.repositorio.PerfilRepository;

@Service
public class PerfilService {
    @Autowired
    PerfilRepository repository;
    
    //C
    public Perfil guardarEntidad(Perfil perfil){
        return repository.save(perfil);
    }
    
    //R
    public List<Perfil> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Perfil actualizarEntidad(Perfil perfil){
        return repository.save(perfil);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Perfil buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
