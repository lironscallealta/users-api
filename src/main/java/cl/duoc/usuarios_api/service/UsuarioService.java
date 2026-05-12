package cl.duoc.usuarios_api.service;

import org.springframework.stereotype.Service;

import cl.duoc.usuarios_api.dto.response.RolResponse;
import cl.duoc.usuarios_api.dto.response.UsuarioResponse;
import cl.duoc.usuarios_api.model.Usuario;
import cl.duoc.usuarios_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse mapToUsuarioToUsuarioResponse(Usuario usuarioModel) {

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        RolResponse rolResponse = new RolResponse();

        usuarioResponse.setNombreCompleto(usuarioModel.getNombre() + " " + usuarioModel.getApellido());
        usuarioResponse.setRut(usuarioModel.getRut() + "-" + usuarioModel.getDv());
        usuarioResponse.setEmail(usuarioModel.getEmail());
        usuarioResponse.setTelefonoCelular(usuarioModel.getTelefonoCelular());
        // setando rol
        rolResponse.setId(usuarioModel.getRol().getId());
        rolResponse.setNombreRol(usuarioResponse.getRol().getNombreRol());
        rolResponse.setDescripcion(usuarioModel.getRol().getDescripcion());
        // Finalizando
        usuarioResponse.setRol(rolResponse);

        return usuarioResponse;
        /*
         * response
         * private Long id;
         * private String nombreCompleto;
         * private String rut;
         * private String email;
         * private String telefonoCelular;
         * private RolResponse rol;
         * private boolean activo;
         */

        /*
         * modelo
         * private Long id;
         * private String nombre;
         * private String apellido;
         * private String rut;
         * private String dv;
         * private string email
         * private String telefonoCelular;
         * private LocalDate fechaNacimiento;
         * private Rol rol;
         * private boolean activo;
         * private LocalDateTime fechaCreacion;
         */

    }

}
