package pe.edu.upeu.syscenterlife.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vent_carrito")
public class VentCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito")
    private Integer idCarrito;
    @Basic(optional = false)
    @Column(name = "dniruc")
    private String dniruc;
    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @Basic(optional = false)
    @Column(name = "punitario")
    private double punitario;
    @Basic(optional = false)
    @Column(name = "ptotal")
    private double ptotal;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    /*@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"compras", "ventas", "compCarritos",
        "ventCarritos"})*/
    private Long idUsuario;
}
