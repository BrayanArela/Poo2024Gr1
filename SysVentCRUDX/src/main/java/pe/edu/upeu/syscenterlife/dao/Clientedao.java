package pe.edu.upeu.syscenterlife.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.syscenterlife.connx.ConnS;
import pe.edu.upeu.syscenterlife.modelo.Cliente;

public class Clientedao {

    ConnS instance = ConnS.getInstance();
    Connection connection = instance.getConnection();
    PreparedStatement ps;
    ResultSet rs = null;

    public List<Cliente> listarCliente() {
        List<Cliente> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * from cliente ");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(Cliente.builder()
                        .dniruc(rs.getString("dniruc"))
                        .nombre(rs.getString("nombre"))
                        .documento(rs.getString("docuneto"))
                        .build());
            }

        } catch (Exception e) {
        }

        return lista;
    }
    public int guardarCliente(Cliente c){ 
        try {
            
            ps = connection.prepareStatement("INSERT INTO cliente(dniruc, nombre, documento)"+"VALUES('"+c.getDniruc()+"', '"+c.getNombre()+"', '"+c.getDocumento()+"')");
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println("Error"+e.getMessage());}
    }

}
