package cl.duoc.usuarios_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.usuarios_api.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

}
