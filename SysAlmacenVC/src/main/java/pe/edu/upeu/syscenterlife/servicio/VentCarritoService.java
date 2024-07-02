package pe.edu.upeu.syscenterlife.servicio;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.VentCarrito;
import pe.edu.upeu.syscenterlife.repositorio.VentCarritoRepository;

@Service
public class VentCarritoService {

    @Autowired
    VentCarritoRepository repository;

    // Crear
    public VentCarrito guardarEntidad(VentCarrito ventCarrito) {
        return repository.save(ventCarrito);
    }

    // Leer todos los elementos
    public List<VentCarrito> listarEntidad() {
        return repository.findAll();
    }

    // Actualizar
    public VentCarrito actualizarEntidad(VentCarrito ventCarrito) {
        return repository.save(ventCarrito);
    }

    // Eliminar
    public void eliminarEntidad(Long id) {
        repository.deleteById(id);
    }

    // Buscar por ID
    public VentCarrito buscarEntidad(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Buscar por DNI/RUC
    public List<VentCarrito> listaCarritoCliente(String dni) {
        return repository.listaCarritoCliente(dni);
    }

    @Transactional
    public void deleteCarAll(String dniruc) {
        this.repository.deleteByDniruc(dniruc);
    }

}
