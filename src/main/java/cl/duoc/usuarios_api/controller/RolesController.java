/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.controller;

import cl.duoc.usuarios_api.dto.response.RolCategoriaResponseDto;
import cl.duoc.usuarios_api.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/roles")
@RequiredArgsConstructor
@Tag(name = "Roles", description = "Operaciones CRUD del dominio roles.")
public class RolesController {

    private final RolesService rolesService;

    @GetMapping
    @Operation(
            summary = "Listar roles",
            description = "Retorna todos los roles registrados con su cantidad de usuarios activos.")
    public ResponseEntity<List<RolCategoriaResponseDto>> consultarRoles() {
        return ResponseEntity.ok(rolesService.consultarRoles());
    }
}
