package pe.edu.upeu.syscenterlife.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.syscenterlife.modelo.Cliente;
import pe.edu.upeu.syscenterlife.repositorio.ClienteRepository;
import pe.edu.upeu.syscenterlife.util.ErrorLogger;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;
    
    ErrorLogger log=new ErrorLogger("ClienteService");

    //C
    public Cliente guardarEntidad(Cliente cliente) {
        return repository.save(cliente);
    }

    //R
    public List<Cliente> listarEntidad() {
        return repository.findAll();
    }

    //U
    public Cliente actualizarEntidad(Cliente cliente) {
        return repository.save(cliente);
    }

    //D
    public void eliminarEntidad(String dniruc) {
        repository.delete(repository.findById(dniruc).get());
    }

    //B
    public Cliente buscarEntidad(String dniruc) {
        return repository.findById(dniruc).get();
    }

    public List<ModeloDataAutocomplet> listAutoComplet(String dato) {
        List<ModeloDataAutocomplet> listarclientes = new ArrayList<>();
        try {
            for (Cliente cliente : repository.listAutoCompletCliente(dato + "%")) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(cliente.getDniruc());
                data.setNombreDysplay(cliente.getNombrers());
                data.setOtherData(cliente.getDocumento());
                listarclientes.add(data);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "create", e);
        }
        return listarclientes;
    }

}
