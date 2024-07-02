package pe.edu.upeu.syspoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.edu.upeu.syspoo.gui.MainGUI;

import java.awt.*;

@Component
public class SpringBootSwingCommandLineRunner implements CommandLineRunner {
    @Autowired
    MainGUI mainGUI;

    @Override
    public void run(String... args) throws Exception {
        EventQueue.invokeLater(()->{
            mainGUI.setVisible(true);
        });
    }
}