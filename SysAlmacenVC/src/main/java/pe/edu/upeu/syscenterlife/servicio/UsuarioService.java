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
    
    // Crear
    public Usuario guardarEntidad(Usuario usuario){
        return repository.save(usuario);
    }
    
    // Leer todos los elementos
    public List<Usuario> listarEntidad(){
        return repository.findAll();
    }
    
    // Actualizar
    public Usuario actualizarEntidad(Usuario usuario){
        return repository.save(usuario);
    }
    
    // Eliminar
    public void eliminarEntidad(Long id){
        repository.deleteById(id);
    }
    
    // Buscar por ID
    public Usuario buscarEntidad(Long id){
        return repository.findById(id).orElse(null);
    }
    
    public Usuario loginUsuario(String user, String clave){
        return repository.loginUsuario(user, clave);
    }
}
