/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pe.edu.upeu.syscenterlife.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import pe.edu.upeu.syscenterlife.componentes.Button;
import pe.edu.upeu.syscenterlife.componentes.FondoPanel;
import pe.edu.upeu.syscenterlife.componentes.MyPasswordField;
import pe.edu.upeu.syscenterlife.componentes.MyTextField;
import pe.edu.upeu.syscenterlife.componentes.PanelBorder;
import pe.edu.upeu.syscenterlife.modelo.SessionManager;
import pe.edu.upeu.syscenterlife.modelo.Usuario;

import pe.edu.upeu.syscenterlife.servicio.PerfilService;

import pe.edu.upeu.syscenterlife.servicio.UsuarioService;
import pe.edu.upeu.syscenterlife.util.MsgBox;
import pe.edu.upeu.syscenterlife.util.UtilsX;


/**
 *
 * @author Datos
 */
@Component
public class Login extends javax.swing.JFrame {

    JPanel panelGeneral;
    FondoPanel fondoPanel = new FondoPanel();
    PanelBorder panelBorder = new PanelBorder();
    MyPasswordField txtPassword;
    MyTextField txtUsername = new MyTextField();
    Button loginButton;

    Button registerButton;
    Button guardarButton;

    UtilsX obj = new UtilsX();
    ConfigurableApplicationContext ctx;
    @Autowired
    GUIMain gUIMain;
    
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PerfilService perfilService;


    public Login() {
        initComponents();
        this.setTitle("Formulario de Ingreso-SysCenterlife");
        this.setIconImage(new ImageIcon(obj.getFile("img/store.png")).getImage());
        try {
            panelGeneral = new JPanel() {
                BufferedImage bufferedImage = ImageIO.read(obj.getFile("img/background.jpg"));

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(bufferedImage, 0, 0, this);
                }
            };
        } catch (Exception e) {
        }
        txtPassword = new MyPasswordField();
        loginButton = new Button();

        guardarButton=new Button();
        registerButton = new Button();

        loginButton.setFont(new Font("sansserif", 1, 20));
        loginButton.setForeground(new Color(7, 164, 121));
        loginButton.setEffectColor(Color.yellow);
        loginButton.setText("Ingresar");

        registerButton.setText("Registrar");

        initCustom();
        this.setContentPane(panelGeneral);
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width / 2, (screenSize.height - 36) / 2));
        this.setLocationRelativeTo(null);

    }

    public void addEventListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Usuario u=usuarioService.loginUsuario(txtUsername.getText(),
                        new String(txtPassword.getPassword()));
                
                if (u!=null) {
                    SessionManager.getInstance().setUserId(u.getIdUsuario());
                    SessionManager.getInstance().setUsuarioNombre(u.getUser());
                    
                    gUIMain.setContexto(ctx);
                    gUIMain.setVisible(true);
                    dispose();
                } else {
                    new MsgBox("Error al ingresar!", NORMAL, "");
                }
            }
        });
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().equals("")) {
                    txtUsername.setText("Coloca tu usuario");
                    txtUsername.setForeground(Color.gray);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Coloca tu usuario")) {
                    txtUsername.setText("");
                    txtUsername.setForeground(Color.black);
                }
            }
        });
        txtPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtPassword.getText().equals("")) {
                    txtPassword.setText("Coloca tu clave");
                    txtPassword.setForeground(Color.gray);
                    txtPassword.setEchoChar((char) 0);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtPassword.getText().equals("Coloca tu clave")) {
                    txtPassword.setText("");
                    txtPassword.setEchoChar('*');
                    txtPassword.setForeground(Color.black);
                }
            }
        });

        
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("si entra");
                panelBorder.removeAll();
                initCustom2();
                panelBorder.repaint();
                panelBorder.validate();
                
                //new Prueba().setVisible(true);

                /*Prueba mc = ctx.getBean(Prueba.class);
                //mc.setContext(ctx);
                mc.setVisible(true);*/
                
            }
        });
    }
    public void addEventListeners2() {
    
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().equals("")) {
                    txtUsername.setText("Coloca tu usuario");
                    txtUsername.setForeground(Color.gray);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Coloca tu usuario")) {
                    txtUsername.setText("");
                    txtUsername.setForeground(Color.black);
                }
            }
        });
        txtPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (txtPassword.getText().equals("")) {
                    txtPassword.setText("Coloca tu clave");
                    txtPassword.setForeground(Color.gray);
                    txtPassword.setEchoChar((char) 0);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (txtPassword.getText().equals("Coloca tu clave")) {
                    txtPassword.setText("");
                    txtPassword.setEchoChar('*');
                    txtPassword.setForeground(Color.black);
                }
            }
        });
        
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("si entra aqui");
                //Guardar
                Usuario u=new Usuario();
                u.setUser(txtUsername.getText());
                u.setClave(new String(txtPassword.getPassword()));
                u.setEstado("Activo");
                u.setIdPerfil(perfilService.buscarEntidad(1L));
                usuarioService.guardarEntidad(u);
                panelBorder.removeAll();
                initCustom();
                panelBorder.repaint();
                panelBorder.validate();
                
                //new Prueba().setVisible(true);

                /*Prueba mc = ctx.getBean(Prueba.class);
                //mc.setContext(ctx);
                mc.setVisible(true);*/
                
            }
        });

    }

    public void initCustom() {
        panelBorder.setPreferredSize(new Dimension(250, 360));
        txtUsername.setPrefixIcon(new ImageIcon(obj.getFile("img/user.png")));
        txtUsername.setHint("User");
        txtPassword.setPrefixIcon(new ImageIcon(obj.getFile("img/pass.png")));
        txtPassword.setHint("Pass");
        loginButton.setBackground(new Color(66, 245, 114));
        loginButton.setFocusPainted(false);
        txtUsername.setText("Coloca tu usuario");
        txtUsername.setForeground(Color.gray);
        txtPassword.setText("Coloca tu clave");
        txtPassword.setForeground(Color.gray);
        txtPassword.setEchoChar((char) 0);

        panelBorder.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("SysCenterlife");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        panelBorder.add(label);
        panelBorder.add(txtUsername, "w 80%");
        panelBorder.add(txtPassword, "w 80%");
        panelBorder.add(loginButton, "w 60%");

        panelBorder.add(registerButton, "w 60%");

        fondoPanel.setPreferredSize(new Dimension(250, 360));
        panelGeneral.add(fondoPanel);
        panelGeneral.add(panelBorder);
        addEventListeners();
    }

    public void initCustom2() {
        panelBorder.setPreferredSize(new Dimension(250, 360));
        txtUsername.setPrefixIcon(new ImageIcon(obj.getFile("img/user.png")));
        txtUsername.setHint("User");
        txtPassword.setPrefixIcon(new ImageIcon(obj.getFile("img/pass.png")));
        txtPassword.setHint("Pass");
        guardarButton.setText("Guardar");
        txtUsername.setText("Coloca tu usuario");
        txtUsername.setForeground(Color.gray);
        txtPassword.setText("Coloca tu clave");
        txtPassword.setForeground(Color.gray);
        txtPassword.setEchoChar((char) 0);
        panelBorder.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("SysCenterlife");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        panelBorder.add(label);
        panelBorder.add(txtUsername, "w 80%");
        panelBorder.add(txtPassword, "w 80%");
        panelBorder.add(guardarButton, "w 60%");
        fondoPanel.setPreferredSize(new Dimension(250, 360));
        panelGeneral.add(fondoPanel);
        panelGeneral.add(panelBorder);
        addEventListeners2();
    }


    public void setContexto(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
