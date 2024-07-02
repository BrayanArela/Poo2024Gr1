package pe.edu.upeu.poo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.poo.modelo.Usuario;
import pe.edu.upeu.poo.service.UsuarioService;

@Component
public class RegistroController {
    @FXML
    private TextField nombreField;
    @FXML
    private TextField dniField;

    @Autowired
    private UsuarioService usuarioService;

    @FXML
    private void registrar() {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombreField.getText());
        usuario.setDni(dniField.getText());
        usuarioService.saveUsuario(usuario);
        System.out.println(usuario.getDni());
        System.out.println("Reporte :");

        for ( Usuario lis:usuarioService.listarUsuario()) {
            System.out.println("nombre: "+lis.getNombre()+"\t"+"dni: "+lis.getDni());
        }

    }
}