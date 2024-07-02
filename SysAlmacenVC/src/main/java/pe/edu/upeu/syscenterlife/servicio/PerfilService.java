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
    
    // Crear
    public Perfil guardarEntidad(Perfil perfil){
        return repository.save(perfil);
    }
    
    // Leer todos los elementos
    public List<Perfil> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Perfil actualizarEntidad(Perfil perfil){
        return repository.save(perfil);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Perfil buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
}
