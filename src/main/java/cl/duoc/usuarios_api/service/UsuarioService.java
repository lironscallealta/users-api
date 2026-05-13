package cl.duoc.usuarios_api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private UsuarioResponseDto mapToUsuarioToUsuarioResponse(Usuario usuarioModel) {

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

    // --
    public Optional<UsuarioResponseDto> consultarUsuarioId(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuario);
        return Optional.of(response);
    }

    // --
    public List<UsuarioResponseDto> consultarUsuariosIds(List<Long> UsuariosId) {

        List<UsuarioResponseDto> listaResponseIds = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAllById(UsuariosId);

        for (Usuario usuario : usuarios) {
            UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuario);
            listaResponseIds.add(response);
        }
        return listaResponseIds;

    }

    // --
    public List<UsuarioResponseDto> consultarUsuarios() {

        List<UsuarioResponseDto> listaUsuarios = new ArrayList<UsuarioResponseDto>();
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario : usuarios) {

            listaUsuarios.add(mapToUsuarioToUsuarioResponse(usuario));
        }

        return listaUsuarios;
    }

    // --
    @Transactional
    public Optional<UsuarioResponseDto> actualizarUsuario(Long usuarioId, UsuarioRequestDto usuarioRequest) {

        Usuario usuarioModel = usuarioRepository.findById(usuarioId).orElseThrow();
        Rol rolModel = rolRepository.findById(usuarioRequest.getRol()).orElseThrow();

        usuarioModel.setNombre(usuarioRequest.getNombre());
        usuarioModel.setApellido(usuarioRequest.getApellido());
        usuarioModel.setRut(usuarioRequest.getRut());
        usuarioModel.setDv(usuarioRequest.getDv());
        usuarioModel.setEmail(usuarioRequest.getEmail());
        usuarioModel.setTelefonoCelular(usuarioRequest.getTelefonoCelular());
        usuarioModel.setFechaNacimiento(usuarioRequest.getFechaNacimiento());
        usuarioModel.setRol(rolModel);
        usuarioModel.setActivo(usuarioRequest.isActivo());
        usuarioModel.setFechaActualizacion(LocalDateTime.now());
        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuarioModel);

        return Optional.of(response);

    }

    // Eliminacion
    @Transactional
    public Optional<UsuarioResponseDto> eliminarUsuarioId(Long usuarioId) {

        // Cambiarlo a la forma de .OrElseThrow estaba probando esta forma para no
        // olvidarla

        Optional<Usuario> usuarioEliminar = usuarioRepository.findById(usuarioId);
        if (usuarioEliminar.isEmpty()) {
            return Optional.empty();
        }
        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuarioEliminar.get());
        usuarioRepository.delete(usuarioEliminar.get());
        return Optional.of(response);

    }

    @Transactional
    public List<UsuarioResponseDto> eliminarUsauriosId(List<Long> ids) {

        List<UsuarioResponseDto> usuariosEliminarResponse = new ArrayList<>();
        List<Usuario> usuariosEliminar = usuarioRepository.findAllById(ids);
        for (Usuario usuario : usuariosEliminar) {
            usuariosEliminarResponse.add(mapToUsuarioToUsuarioResponse(usuario));

        }
        usuarioRepository.deleteAllById(ids);
        return usuariosEliminarResponse;

    }

    @Transactional
    public List<UsuarioResponseDto> eliminarUsuarios() {
        List<Usuario> usuariosEliminar = usuarioRepository.findAll();
        List<UsuarioResponseDto> usuariosEliminarResponse = new ArrayList<>();
        for (Usuario usuario : usuariosEliminar) {
            usuariosEliminarResponse.add(mapToUsuarioToUsuarioResponse(usuario));

        }
        usuarioRepository.deleteAll();
        return usuariosEliminarResponse;

    }

}
