package cl.duoc.usuarios_api.repository.perfiles.sistema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.usuarios_api.model.perfiles.sistema.AbastecimientoCompras;

@Repository
public interface AbastecimientoComprasRepository extends JpaRepository<AbastecimientoCompras, Long> {
}
