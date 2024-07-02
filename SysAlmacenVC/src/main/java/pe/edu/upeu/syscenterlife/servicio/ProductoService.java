package pe.edu.upeu.syscenterlife.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.syscenterlife.autocomp.ModeloDataAutocomplet;
import pe.edu.upeu.syscenterlife.modelo.Producto;
import pe.edu.upeu.syscenterlife.repositorio.ProductoRepository;
import pe.edu.upeu.syscenterlife.util.ErrorLogger;


@Service
public class ProductoService {

    @Autowired
    ProductoRepository repository;
    ErrorLogger log=new ErrorLogger("ProductoService");
    // Crear
    public Producto guardarEntidad(Producto producto) {
        return repository.save(producto);
    }

    // Leer todos los elementos
    public List<Producto> listarEntidad() {
        return repository.findAll();
    }

    // Actualizar
    public Producto actualizarEntidad(Producto producto) {
        return repository.save(producto);
    }

    // Eliminar
    public void eliminarEntidad(Long id) {
        repository.deleteById(id);
    }

    // Buscar por ID
    public Producto buscarEntidad(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ModeloDataAutocomplet> listAutoCompletProducto(String nombre) {
        List<ModeloDataAutocomplet> listarProducto = new ArrayList<>();
        try {
            for (Producto producto : repository.listAutoCompletProducto(nombre + "%")) {
                ModeloDataAutocomplet data = new ModeloDataAutocomplet();
                ModeloDataAutocomplet.TIPE_DISPLAY = "ID";
                data.setIdx(producto.getNombre());
                data.setNombreDysplay(String.valueOf(producto.getIdProducto()));
                data.setOtherData(producto.getPu() + ":" + producto.getStock());
                listarProducto.add(data);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "create", e);
        }
        return listarProducto;
    }
}
