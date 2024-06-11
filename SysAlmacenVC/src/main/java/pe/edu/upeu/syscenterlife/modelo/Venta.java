package pe.edu.upeu.syscenterlife.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Basic(optional = false)
    @Column(name = "preciobase")
    private double preciobase;
    @Basic(optional = false)
    @Column(name = "igv")
    private double igv;
    @Basic(optional = false)
    @Column(name = "preciototal")
    private double preciototal;
    @Basic(optional = false)
    @Column(name = "num_doc")
    private String numDoc;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Basic(optional = false)
    @Column(name = "fecha_gener")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaGener;
    @Basic(optional = false)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @JoinColumn(name = "dniruc", referencedColumnName = "dniruc")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"ventas"})
    private Cliente dniruc;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties({"compras", "ventas", "compCarritos",
        "ventCarritos"})
    private Usuario idUsuario;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @JsonIgnoreProperties({"idVenta"})
    public List<VentaDetalle> ventaDetalles;
}
