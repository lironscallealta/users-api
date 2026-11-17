/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.request.RolRequestDto;
import cl.duoc.usuarios_api.dto.response.RolCategoriaResponseDto;
import cl.duoc.usuarios_api.dto.response.RolResponseDto;
import cl.duoc.usuarios_api.exception.BadRequestException;
import cl.duoc.usuarios_api.exception.ResourceNotFoundException;
import cl.duoc.usuarios_api.model.Rol;
import cl.duoc.usuarios_api.repository.RolRepository;
import cl.duoc.usuarios_api.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RolesService {

    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;

    private RolResponseDto mapRolToRolResponse(Rol rol) {
        return RolResponseDto.builder()
                .id(rol.getId())
                .nombreRol(rol.getNombreRol())
                .nombreMostrar(rol.getNombreMostrar())
                .icon(rol.getIcon())
                .descripcion(rol.getDescripcion())
                .build();
    }

    @Transactional(readOnly = true)
    public List<RolCategoriaResponseDto> consultarRoles() {
        List<RolCategoriaResponseDto> listaRoles = new ArrayList<>();

        long totalUsuarios = usuarioRepository.count();
        listaRoles.add(
                new RolCategoriaResponseDto(0L, "👥", "Todos los usuarios", "todos", totalUsuarios, Boolean.TRUE));

        Map<Long, Long> cantidadesPorRol = new HashMap<>();
        for (var conteo : usuarioRepository.countGroupByRol()) {
            cantidadesPorRol.put(conteo.getRolId(), conteo.getTotal());
        }

        List<Rol> roles = rolRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        for (Rol rol : roles) {
            listaRoles.add(new RolCategoriaResponseDto(
                    rol.getId(),
                    rol.getIcon(),
                    rol.getNombreMostrar(),
                    rol.getNombreRol(),
                    cantidadesPorRol.getOrDefault(rol.getId(), 0L),
                    null));
        }

        return listaRoles;
    }

    @Transactional
    public RolResponseDto crearRol(RolRequestDto rolRequest) {
        log.info("Creando rol: {}", rolRequest.getNombreRol());

        if (rolRequest.getNombreRol() == null || rolRequest.getNombreRol().isBlank()) {
            throw new BadRequestException("El nombre del rol es requerido y no puede estar vacío.");
        }
        if (rolRequest.getNombreMostrar() == null
                || rolRequest.getNombreMostrar().isBlank()) {
            throw new BadRequestException("El nombre a mostrar del rol es requerido y no puede estar vacío.");
        }
        if (rolRequest.getIcon() == null || rolRequest.getIcon().isBlank()) {
            throw new BadRequestException("El ícono del rol es requerido y no puede estar vacío.");
        }
        if (rolRequest.getDescripcion() == null || rolRequest.getDescripcion().isBlank()) {
            throw new BadRequestException("La descripción del rol es requerida y no puede estar vacía.");
        }

        Rol newRol = new Rol();
        newRol.setNombreRol(rolRequest.getNombreRol());
        newRol.setNombreMostrar(rolRequest.getNombreMostrar());
        newRol.setIcon(rolRequest.getIcon());
        newRol.setDescripcion(rolRequest.getDescripcion());

        Rol rolGuardado = rolRepository.save(newRol);
        RolResponseDto response = mapRolToRolResponse(rolGuardado);

        return response;
    }

    @Transactional
    public RolResponseDto actualizarRol(Long rolId, RolRequestDto rolRequest) {

        Rol rolModel = rolRepository
                .findById(rolId)
                .orElseThrow(() -> new ResourceNotFoundException("El rol con ID " + rolId + " no existe"));

        rolModel.setNombreRol(rolRequest.getNombreRol());
        rolModel.setNombreMostrar(rolRequest.getNombreMostrar());
        rolModel.setIcon(rolRequest.getIcon());
        rolModel.setDescripcion(rolRequest.getDescripcion());

        Rol rolGuardado = rolRepository.save(rolModel);
        return mapRolToRolResponse(rolGuardado);
    }

    @Transactional
    public void eliminarRolId(Long rolId) {
        Rol rolEliminar = rolRepository
                .findById(rolId)
                .orElseThrow(() -> new ResourceNotFoundException("no se puede eliminar rol con id: " + rolId));
        rolRepository.delete(rolEliminar);
    }
}
