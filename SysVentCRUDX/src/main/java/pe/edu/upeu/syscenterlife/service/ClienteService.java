package pe.edu.upeu.syscenterlife.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.dao.Clientedao;
import pe.edu.upeu.syscenterlife.modelo.Cliente;

@Service
public class ClienteService {

    Clientedao clienteDao= new Clientedao();

    List<Cliente> listaCli = new ArrayList<>(); //arraylist

    public boolean saveEntidad(Cliente cliente) {//Create
        return clientedao.guardarCliente(cliente)==1?true:false;
    }

    public List<Cliente> listarEntidad() { //Report
        return clienteDao.listarCliente();
    }

    public Cliente buscarCliente(String dnirucx) {
        return listaCli.stream()
                .filter(cliente -> cliente.getDniruc().equals(dnirucx))
                .findFirst()
                .orElse(null); // Devuelve null si no se encuentra ningún cliente
    }

    public Cliente updateEntidad(Cliente clientex) { //update
        listaCli.stream()
                .filter(cliente
                        -> cliente.getDniruc().equals(clientex.getDniruc())) // Filtrar por DNI
                .findFirst() // Obtener el primer cliente que cumpla con el filtro
                .ifPresent(cliente
                        -> cliente.setNombre(clientex.getNombre()));
        //return this.listaCli.set(index, cliente);
        return buscarCliente(clientex.getDniruc());
    }

    public void deleteRegistEntdad(String dato) { //delete
        listaCli.remove(listaCli.stream()
                .filter(cliente -> cliente.getDniruc().equals(dato))
                .findFirst().orElse(null));
    }
}
