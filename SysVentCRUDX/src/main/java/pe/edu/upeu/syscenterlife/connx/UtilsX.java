package pe.edu.upeu.syscenterlife.connx;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilsX {

    public File getFileExterno(String carpeta, String filex) {
        File newFolder = new File(carpeta);
        String ruta = newFolder.getAbsolutePath();
        Path CAMINO = Paths.get(ruta + "/" + filex);
        return CAMINO.toFile();
    }

}
