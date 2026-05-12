package cl.duoc.usuarios_api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Service;

import cl.duoc.usuarios_api.dto.request.UsuarioRequestDto;
import cl.duoc.usuarios_api.dto.response.RolResponseDto;
import cl.duoc.usuarios_api.dto.response.UsuarioResponseDto;
import cl.duoc.usuarios_api.model.Rol;
import cl.duoc.usuarios_api.model.Usuario;
import cl.duoc.usuarios_api.repository.RolRepository;
import cl.duoc.usuarios_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioResponseDto mapToUsuarioToUsuarioResponse(Usuario usuarioModel) {

        // La forma que encontre para sacar años, lo dejo configurado
        int edadConfigurada = Period.between(usuarioModel.getFechaNacimiento(), LocalDate.now()).getYears();

        UsuarioResponseDto usuarioResponse = new UsuarioResponseDto();
        RolResponseDto rolResponse = new RolResponseDto();
        // usuario
        usuarioResponse.setId(usuarioModel.getId());
        usuarioResponse.setNombreCompleto(usuarioModel.getNombre() + " " + usuarioModel.getApellido());
        usuarioResponse.setRut(usuarioModel.getRut() + "-" + usuarioModel.getDv());
        usuarioResponse.setEdad(edadConfigurada);
        usuarioResponse.setEmail(usuarioModel.getEmail());
        usuarioResponse.setTelefonoCelular(usuarioModel.getTelefonoCelular());
        usuarioResponse.setActivo(true);
        // setando rol
        rolResponse.setId(usuarioModel.getRol().getId());
        rolResponse.setNombreRol(usuarioResponse.getRol().getNombreRol());
        rolResponse.setDescripcion(usuarioModel.getRol().getDescripcion());
        // Finalizando
        usuarioResponse.setRol(rolResponse);

        return usuarioResponse;

        /*
         * modelo como guia
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

    public UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequest) {

        Usuario usuarioModel = new Usuario();
        Rol rol = rolRepository.findById(usuarioRequest.getRol()).orElseThrow();

        usuarioModel.setNombre(usuarioRequest.getNombre());
        usuarioModel.setApellido(usuarioRequest.getApellido());
        usuarioModel.setRut(usuarioRequest.getRut());
        usuarioModel.setDv(usuarioRequest.getDv());
        usuarioModel.setEmail(usuarioRequest.getEmail());
        usuarioModel.setTelefonoCelular(usuarioRequest.getTelefonoCelular());
        usuarioModel.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        usuarioModel.setRol(rol);
        usuarioModel.setActivo(usuarioRequest.isActivo());
        usuarioModel.setFechaCreacion(LocalDateTime.now());

        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuarioModel);

        return response;
    }

}
