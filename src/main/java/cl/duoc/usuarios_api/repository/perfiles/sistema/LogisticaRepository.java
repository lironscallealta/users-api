package cl.duoc.usuarios_api.repository.perfiles.sistema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.usuarios_api.model.perfiles.sistema.Logistica;

@Repository
public interface LogisticaRepository extends JpaRepository<Logistica, Long> {
}
