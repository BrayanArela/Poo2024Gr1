package pe.edu.upeu.syscenterlife.modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Emisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emisor")
    private Integer idEmisor;
    @Basic(optional = false)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @Column(name = "ubigeo")
    private String ubigeo;
    @Basic(optional = false)
    @Column(name = "domicilio_fiscal")
    private String domicilioFiscal;
    @Basic(optional = false)
    @Column(name = "urbanizacion")
    private String urbanizacion;
    @Basic(optional = false)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "distrito")
    private String distrito;
}
