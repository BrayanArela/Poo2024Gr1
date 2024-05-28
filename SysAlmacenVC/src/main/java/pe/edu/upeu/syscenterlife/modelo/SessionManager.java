package pe.edu.upeu.syscenterlife.modelo;

import lombok.Data;

@Data
public class SessionManager {

    static SessionManager instance;
    Long userId;
    String usuarioNombre;

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
}
