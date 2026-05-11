package cl.duoc.usuarios_api.repository.perfiles.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.usuarios_api.model.perfiles.clientes.ClienteMayorista;

@Repository
public interface ClienteMayoristaRepository extends JpaRepository<ClienteMayorista, Long> {
}
