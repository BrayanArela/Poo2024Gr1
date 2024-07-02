package pe.edu.upeu.syscenterlife.servicio;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.syscenterlife.modelo.Venta;
import pe.edu.upeu.syscenterlife.repositorio.VentaRepository;

@Service
public class VentaService {

    @Autowired
    VentaRepository repository;

    @Autowired
    private DataSource dataSource;

    // Crear
    public Venta guardarEntidad(Venta venta) {
        return repository.save(venta);
    }

    // Leer todos los elementos
    public List<Venta> listarEntidad() {
        return repository.findAll();
    }

    // Actualizar
    public Venta actualizarEntidad(Venta venta) {
        return repository.save(venta);
    }

    // Eliminar
    public void eliminarEntidad(Long id) {
        repository.deleteById(id);
    }

    // Buscar por ID
    public Venta buscarEntidad(Long id) {
        return repository.findById(id).orElse(null);
    }

    public File getFile(String filex) {
        File newFolder = new File("jasper");
        String ruta = newFolder.getAbsolutePath();
        //CAMINO = Paths.get(ruta+"/"+"reporte1.jrxml");
        Path CAMINO = Paths.get(ruta + "/" + filex);
        System.out.println("Llegasss Ruta 2:" + CAMINO.toFile().getAbsolutePath());
        return CAMINO.toFile();
    }

    public void runReport1(Long idv) {
        try {
            // Verificar si la venta existe
            if (!repository.existsById(idv)) {
                throw new IllegalArgumentException("La venta con id " + idv + " no existe");
            }
            HashMap<String, Object> param = new HashMap<>();
            // Obtener ruta de la imagen
            String imgen = getFile("logoupeu.png").getAbsolutePath();
            // Agregar parámetros
            param.put("idventa", idv);
            param.put("imagenurl", imgen);
            // Cargar el diseño del informe
            JasperDesign jdesign = JRXmlLoader.load(getFile("comprobante.jrxml"));
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            // Llenar el informe
            JasperPrint jprint = JasperFillManager.fillReport(jreport, param,
                    dataSource.getConnection());
            // Mostrar el informe
            JasperViewer.viewReport(jprint, false);
        } catch (JRException ex) {
            System.out.println("Error:\n" + ex.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado:\n" + e.getLocalizedMessage());
        }
    }

}
