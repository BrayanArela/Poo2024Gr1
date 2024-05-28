package pe.edu.upeu.syscenterlife.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.syscenterlife.modelo.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
}
