package pe.edu.upeu.syscenterlife.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Cliente;
import pe.edu.upeu.syscenterlife.repositorio.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;
    
    //C
    public Cliente guardarEntidad(Cliente cliente){
    return repository.save(cliente);
    }
    //R
    public List<Cliente> listarEntidad(){
    return repository.findAll();
    }
    //U
    public Cliente actualizarEntidad(Cliente cliente){
    return repository.save(cliente);
    }
    //D
    public void eliminarEntidad(String dniruc){
        repository.delete(repository.findById(dniruc).get());
    }
    //B
    public Cliente buscarEntidad(String dniruc){
    return repository.findById(dniruc).get();
    }
}
