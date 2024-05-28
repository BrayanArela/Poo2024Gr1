package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Usuario;
import pe.edu.upeu.syscenterlife.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;
    
    //C
    public Usuario guardarEntidad(Usuario usuario){
        return repository.save(usuario);
    }
    
    //R
    public List<Usuario> listarEntidad(){
        return repository.findAll();
    }
    
    //U
    public Usuario actualizarEntidad(Usuario usuario){
        return repository.save(usuario);
    }
    
    //D
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    //B
    public Usuario buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
    public Usuario looginUsuario(String user, String clave){
        return repository.loginUsuario(user, clave);
    }
}
