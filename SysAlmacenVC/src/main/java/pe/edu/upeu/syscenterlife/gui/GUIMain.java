/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.syscenterlife.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import pe.edu.upeu.syscenterlife.modelo.MenuMenuItenTO;
import pe.edu.upeu.syscenterlife.servicio.MenuMenuItemDao;
import pe.edu.upeu.syscenterlife.servicio.MenuMenuItemDaoI;
import pe.edu.upeu.syscenterlife.util.UtilsX;

@Component
public class GUIMain extends JFrame {

    Preferences userPrefs = Preferences.userRoot();
    JMenuBar menuBar;
    JTabbedPane jtpane;
    JScrollPane scrollPane;
    JMenu[] menu;
    JMenuItem[] jmItem;
    UtilsX util = new UtilsX();
    Properties myresources = new Properties();
    List<MenuMenuItenTO> lista;
    MenuMenuItemDaoI mmiDao;
    ConfigurableApplicationContext ctx;

    public GUIMain() {
        myresources = util.detectLanguage(userPrefs.get("IDIOMAX", "es"));
        mmiDao = new MenuMenuItemDao();
        lista = mmiDao.listaAccesos("Root", myresources);
        int[] mmi = contarMenuMunuItem(lista);
        menu = new JMenu[mmi[0]];
        jmItem = new JMenuItem[mmi[1]];
        menuBar = new JMenuBar();
        MenuItemListener d = new MenuItemListener();
        SampleMenuListener m = new SampleMenuListener();
        this.setTitle("SystemMain@DMP");
        this.setIconImage(new ImageIcon(util.getFile("img/store.png")).getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, (screenSize.height)
                - 36));
        String menuN = "";
        int menui = 0, menuitem = 0;
        char conti = 'N';
        for (MenuMenuItenTO mmix : lista) {
            if (!mmix.menunombre.equals(menuN)) {
                menu[menui] = new JMenu(mmix.menunombre);
                menu[menui].setName("m" + mmix.nombreObj);
                menu[menui].addMenuListener(m);
                if (!mmix.menuitemnombre.equals("")) {
                    jmItem[menuitem] = new JMenuItem(mmix.menuitemnombre);
                    jmItem[menuitem].setName("mi" + mmix.nombreObj);
                    jmItem[menuitem].addActionListener(d);
                    menu[menui].add(jmItem[menuitem]);
                    menuitem++;
                }
                menuBar.add(menu[menui]);
                menuN = mmix.menunombre;
                conti = 'N';
                menui++;
            } else {
                conti = 'S';
            }
            System.out.println("MI:" + menuitem);
            if (!mmix.menuitemnombre.equals("")
                    && mmix.menunombre.equals(menuN) && conti == 'S') {
                jmItem[menuitem] = new JMenuItem(mmix.menuitemnombre);
                jmItem[menuitem].setName("mi" + mmix.nombreObj);
                jmItem[menuitem].addActionListener(d);
                menu[menui - 1].add(jmItem[menuitem]);
                menuitem++;
            }
        }
        jtpane = new JTabbedPane();
        this.getContentPane().add(BorderLayout.NORTH, menuBar);
        this.add(BorderLayout.CENTER, jtpane);
    }

    public int[] contarMenuMunuItem(List<MenuMenuItenTO> data) {
        int menui = 0, menuitem = 0;
        String menuN = "";
        for (MenuMenuItenTO mmi : data) {
            if (!mmi.menunombre.equals(menuN)) {
                menuN = mmi.menunombre;
                menui++;
            }
            if (!mmi.menuitemnombre.equals("")) {
                menuitem++;
            }
        }
        return new int[]{menui, menuitem};
    }

    public void setContexto(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    class SampleMenuListener implements MenuListener {

        @Override
        public void menuSelected(MenuEvent e) {
            System.out.println("menuSelected");
            if (((JMenu) e.getSource()).getName().equals("mmiver1")) {
                System.out.println("llego help");
            }
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }

    class MenuItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("pasa por aqui");
            Container contai = GUIMain.this.getContentPane();
            if (((JMenuItem) e.getSource()).getName()
                    .equals("micliente")) {
                System.out.println("Holas si llega");
                jtpane.removeAll();
                //MainCliente mc = new MainCliente();
                MainCliente mc = ctx.getBean(MainCliente.class);
                mc.setContext(ctx);
                mc.setPreferredSize(new Dimension(1024, 600));
                scrollPane = new JScrollPane(mc);
                scrollPane.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                jtpane.add(scrollPane, "Cliente");
                contai.add(BorderLayout.CENTER, jtpane);
                contai.validate();
                contai.repaint();
            }
            if (((JMenuItem) e.getSource()).getName().equals("miareaperiodo")) {
                System.out.println("Holas si llega");
                jtpane.removeAll();
                //MainCliente mc = new MainCliente();
                MainVenta mv = ctx.getBean(MainVenta.class);
                mv.setContexto(ctx);
                mv.setPreferredSize(new Dimension(1024, 600));
                scrollPane = new JScrollPane(mv);
                scrollPane.setHorizontalScrollBarPolicy(
                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                jtpane.add(scrollPane, "R.Venta");
                contai.add(BorderLayout.CENTER, jtpane);
                contai.validate();
                contai.repaint();
            }
            if (((JMenuItem) e.getSource()).getName().equals("mimiselectall")) {
                jtpane.removeAll();//remueve todo el contenido
            }
        }
    }

}
