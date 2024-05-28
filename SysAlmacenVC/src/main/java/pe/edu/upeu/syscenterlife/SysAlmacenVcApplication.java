package pe.edu.upeu.syscenterlife;

import java.awt.EventQueue;
import java.util.prefs.Preferences;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pe.edu.upeu.syscenterlife.gui.Login;
import pe.edu.upeu.syscenterlife.util.UtilsX;

@SpringBootApplication
public class SysAlmacenVcApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SysAlmacenVcApplication.class, args);
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SysAlmacenVcApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        Preferences userPrefs = Preferences.userRoot();
        userPrefs.put("IDIOMAX", new UtilsX().readLanguageFile());
        userPrefs.put("PERFIL", "Admin");
        EventQueue.invokeLater(() -> {
            Login ex = ctx.getBean(Login.class);
            ex.setContexto(ctx);
            ex.setVisible(true);
        });

    }

}
