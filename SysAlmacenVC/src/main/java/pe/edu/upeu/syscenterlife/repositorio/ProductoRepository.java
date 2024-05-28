package pe.edu.upeu.syscenterlife.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.syscenterlife.modelo.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
