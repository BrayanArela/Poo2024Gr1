package pe.edu.upeu.syscenterlife.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import org.springframework.context.ConfigurableApplicationContext;

public class GUIMain extends JFrame {

    JTabbedPane jtpane;
    JScrollPane scrollPane;
    ConfigurableApplicationContext ctx;

    public GUIMain() {
        this.setTitle("SystemMain@DMP");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, (screenSize.height)
                - 36));
        MainCliente mc = new MainCliente();
        //mc.setContexto(ctx);
        mc.setPreferredSize(new Dimension(1024, 600));
        jtpane = new JTabbedPane();
        jtpane.setName("Cliente");
        jtpane.add(mc);
        scrollPane = new JScrollPane(mc);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jtpane.add(scrollPane, "Cliente");
        this.add(BorderLayout.CENTER, jtpane);
        this.validate();
        this.repaint();
    }

    public void setContexto(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    public static void main(String[] args) {
        new GUIMain().setVisible(true);
    }
}
