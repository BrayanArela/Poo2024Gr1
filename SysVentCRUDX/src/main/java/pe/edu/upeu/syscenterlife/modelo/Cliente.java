package pe.edu.upeu.syscenterlife.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data

public class Cliente {

    String dniruc;
    String nombre;
    String documento;

}
