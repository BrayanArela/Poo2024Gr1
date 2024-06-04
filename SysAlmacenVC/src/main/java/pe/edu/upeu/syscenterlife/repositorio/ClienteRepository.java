package pe.edu.upeu.syscenterlife.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.syscenterlife.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value = "SELECT * FROM cliente WHERE nombrers LIKE :nombre", nativeQuery = true)
    List<Cliente> buscarPorNombre(@Param(value = "nombre") String nombre);

    @Query(value = "SELECT c.* FROM Cliente c WHERE c.nombrers like :filter", nativeQuery = true)
    List<Cliente> listAutoCompletCliente(@Param("filter") String filter);

}
