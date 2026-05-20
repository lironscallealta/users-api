/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.request.UsuarioRequestDto;
import cl.duoc.usuarios_api.dto.response.RolResponseDto;
import cl.duoc.usuarios_api.dto.response.UsuarioResponseDto;
import cl.duoc.usuarios_api.exception.BadRequestException;
import cl.duoc.usuarios_api.exception.ResourceNotFoundException;
import cl.duoc.usuarios_api.model.Rol;
import cl.duoc.usuarios_api.model.Usuario;
import cl.duoc.usuarios_api.repository.RolRepository;
import cl.duoc.usuarios_api.repository.UsuarioRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    private UsuarioResponseDto mapToUsuarioToUsuarioResponse(Usuario usuarioModel) {

        // La forma que encontre para sacar años, lo dejo configurado
        int edadConfigurada = Period.between(usuarioModel.getFechaNacimiento(), LocalDate.now())
                .getYears();

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
        rolResponse.setNombreRol(usuarioModel.getRol().getNombreRol());
        rolResponse.setDescripcion(usuarioModel.getRol().getDescripcion());
        // Finalizando
        usuarioResponse.setRol(rolResponse);

        return usuarioResponse;
    }

    @Transactional
    public UsuarioResponseDto crearUsuario(UsuarioRequestDto usuarioRequest) {
        log.info("Creando usuario: {} {}", usuarioRequest.getNombre(), usuarioRequest.getApellido());

        if (usuarioRequest.getNombre() == null || usuarioRequest.getNombre().isBlank()) {
            throw new BadRequestException("El nombre del usuario es requerido y no puede estar vacío.");
        }
        if (usuarioRequest.getApellido() == null || usuarioRequest.getApellido().isBlank()) {
            throw new BadRequestException("El apellido del usuario es requerido y no puede estar vacío.");
        }
        if (usuarioRequest.getEmail() == null || usuarioRequest.getEmail().isBlank()) {
            throw new BadRequestException("El email del usuario es requerido y no puede estar vacío.");
        }

        Usuario usuarioModel = new Usuario();
        Rol rol = rolRepository
                .findById(usuarioRequest.getRol())
                .orElseThrow(
                        () -> new ResourceNotFoundException("El rol con ID " + usuarioRequest.getRol() + " no existe"));

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

        Usuario usuarioGuardado = usuarioRepository.save(usuarioModel);
        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuarioGuardado);

        return response;
    }

    public Optional<UsuarioResponseDto> consultarUsuarioId(Long usuarioId) {

        Usuario usuario = usuarioRepository
                .findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("no se encuentra usuario con id: " + usuarioId));
        UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuario);
        return Optional.of(response);
    }

    public List<UsuarioResponseDto> consultarUsuariosIds(List<Long> UsuariosId) {

        List<UsuarioResponseDto> listaResponseIds = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAllById(UsuariosId);

        for (Usuario usuario : usuarios) {
            UsuarioResponseDto response = mapToUsuarioToUsuarioResponse(usuario);
            listaResponseIds.add(response);
        }
        return listaResponseIds;
    }

    public List<UsuarioResponseDto> consultarUsuarios() {

        List<UsuarioResponseDto> listaUsuarios = new ArrayList<UsuarioResponseDto>();
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario : usuarios) {

            listaUsuarios.add(mapToUsuarioToUsuarioResponse(usuario));
        }

        return listaUsuarios;
    }

    @Transactional
    public Optional<UsuarioResponseDto> actualizarUsuario(Long usuarioId, UsuarioRequestDto usuarioRequest) {

        Usuario usuarioModel = usuarioRepository
                .findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("no existe usuario con id:  " + usuarioId));
        Rol rolModel = rolRepository
                .findById(usuarioRequest.getRol())
                .orElseThrow(
                        () -> new ResourceNotFoundException("El rol con ID " + usuarioRequest.getRol() + " no existe"));

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

    @Transactional
    public void eliminarUsuarioId(Long usuarioId) {

        Usuario usuarioEliminar = usuarioRepository
                .findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("no se puede eliminar usuario con id: " + usuarioId));
        usuarioRepository.delete(usuarioEliminar);
    }

    @Transactional
    public void eliminarUsuariosIds(List<Long> ids) {
        usuarioRepository.deleteAllById(ids);
    }

    @Transactional
    public void eliminarUsuarios() {
        usuarioRepository.deleteAll();
    }
}
