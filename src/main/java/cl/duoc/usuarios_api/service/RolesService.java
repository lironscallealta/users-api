/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.response.RolCategoriaResponseDto;
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

    @Transactional(readOnly = true)
    public List<RolCategoriaResponseDto> consultarRoles() {
        List<RolCategoriaResponseDto> listaRoles = new ArrayList<>();

        long totalActivos = usuarioRepository.countByActivoTrue();
        listaRoles.add(
                new RolCategoriaResponseDto(0L, "👥", "Todos los usuarios", "todos", totalActivos, Boolean.TRUE));

        Map<Long, Long> cantidadesPorRol = new HashMap<>();
        for (var conteo : usuarioRepository.countActivosByRol()) {
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
}
