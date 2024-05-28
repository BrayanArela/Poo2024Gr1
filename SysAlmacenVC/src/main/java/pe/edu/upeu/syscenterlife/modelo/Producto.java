package pe.edu.upeu.syscenterlife.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "pu")
    private double pu;
    @Basic(optional = false)
    @Column(name = "puold")
    private double puold;
    @Basic(optional = false)
    @Column(name = "utilidad")
    private double utilidad;
    @Basic(optional = false)
    @Column(name = "stock")
    private double stock;
    @Basic(optional = false)
    @Column(name = "stockold")
    private double stockold;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"productos"})
    private Categoria idCategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"productos"})
    private Marca idMarca;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"productos"})
    private UnidMedida idUnidad;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @JsonIgnoreProperties({"idProducto"})
    public List<CompraDetalle> compraDetalles;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @JsonIgnoreProperties({"idProducto"})
    public List<VentaDetalle> ventaDetalles;
    
}
