/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.repository;

import cl.duoc.usuarios_api.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    long countByEstadoId(Long estadoId);

    @Query("SELECT u.rol.id AS rolId, COUNT(u) AS total FROM Usuario u WHERE u.estado.id = :estadoId GROUP BY u.rol.id")
    List<RolCountProjection> countByEstadoIdGroupByRol(@Param("estadoId") Long estadoId);
}
