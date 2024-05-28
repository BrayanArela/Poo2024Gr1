package pe.edu.upeu.syscenterlife.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class Cliente {

    @Id
    @Basic(optional = false)
    String dniruc;
    @Basic(optional = false)
    String nombrers;
    String documento;
    String direccion;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dniruc", referencedColumnName = "dniruc")
    @JsonIgnoreProperties({"dniruc"})
    public List<Venta> ventas;
}
