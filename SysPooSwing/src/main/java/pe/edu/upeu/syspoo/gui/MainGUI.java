package pe.edu.upeu.syspoo.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.syspoo.modelo.Usuario;
import pe.edu.upeu.syspoo.service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

@Component
public class MainGUI extends JFrame {

    static JButton b1, b2, b3;
    static JTextField txtDato1=new JTextField(10), txtDato2=new JTextField(6);
    
    static JLabel l, lbnDato1=new JLabel("Nombre:"), lbnDato2=new JLabel("DNI:");
    static JList lista, lista2;
    static JPanel p, p2;
    //ArrayList<String> arrayListX = new ArrayList<String>();
    ArrayList<Usuario> arrayListU = new ArrayList<Usuario>();
    LinkedList<String> arrayListX = new LinkedList<String>();
    //HashMap<String, String> hasMapList = new HashMap<String, String>();
    HashSet<String> hasMapList = new HashSet<String>();

    @Autowired
    private UsuarioService usuarioService;

    public MainGUI(){
        this.setTitle("Person Management UI");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height-36));
        // Creating a label to display text
        l = new JLabel("Panel 2:");

        // Creating a new buttons               
        b2 = new JButton("Mostrar");
        b1 = new JButton("Guardar");
        b3=new JButton("HasMap");
        // Creating a panel to add buttons
        p= new JPanel();

        p.add(b2);               
        p.setBackground(Color.DARK_GRAY);
        p.add(l);
        p2=new JPanel(); 
        // Adding panel to frame
        
        MenuItemListener menuItemListener = new MenuItemListener();
        b2.addActionListener(menuItemListener); 
        b1.addActionListener(menuItemListener); 
        b3.addActionListener(menuItemListener); 
        this.add(p);
        this.show();
    }

    // Main class
    /*public static void main(String[] args){
        new MainGUI();
    }*/
    
    class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("pasa por aqui");            
            if (e.getSource() == b2) {           
                p2.removeAll();             
                p2.add(lbnDato1);                
                p2.add(txtDato1);
                p2.add(lbnDato2);                
                p2.add(txtDato2);
                
                arrayListX.add("Raul");
                lista=new JList(arrayListX.toArray());
                //lista.setListData();
                //hasMapList.put("42631718", "Pedro");
                hasMapList.add("Pedro");
                //lista2=new JList(hasMapList.entrySet().toArray());
                lista2=new JList(hasMapList.toArray());
                lista.setBounds(100,100, 75,75);                 
                p2.add(lista);
                p2.add(lista2);
                
                p.add(p2);                  
                p.add(b1);
                p.add(b3);
                b2.setEnabled(false);
                p.invalidate();
                p.validate();
                p.repaint();
            }

            if (e.getSource() == b1) {
                arrayListX.addFirst(txtDato1.getText());
                lista.removeAll();
                lista.setListData(arrayListX.toArray());
                Usuario u=new Usuario();
                u.setNombre(txtDato1.getText());
                u.setDni(txtDato2.getText());
                usuarioService.saveUsuario(u);

                for ( Usuario lis:usuarioService.listarUsuario()) {
                    System.out.println("nombre: "+lis.getNombre()+"\t"+"dni: "+lis.getDni());
                }
                lista.invalidate();
                lista.validate();
                lista.repaint();
            }            
            if (e.getSource() == b3) {
                //hasMapList.put(txtDato2.getText(), txtDato1.getText());
                hasMapList.add(txtDato2.getText());
                lista2.removeAll();
                //lista2.setListData(hasMapList.entrySet().toArray());
                lista2.setListData(hasMapList.toArray());
                lista2.invalidate();
                lista2.validate();
                lista2.repaint();
            }            
        }        
    }
}
