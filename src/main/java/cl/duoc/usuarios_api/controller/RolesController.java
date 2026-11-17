/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.controller;

import cl.duoc.usuarios_api.dto.request.RolRequestDto;
import cl.duoc.usuarios_api.dto.response.RolCategoriaResponseDto;
import cl.duoc.usuarios_api.dto.response.RolResponseDto;
import cl.duoc.usuarios_api.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/roles")
@RequiredArgsConstructor
@Tag(name = "Roles", description = "Operaciones CRUD del dominio roles.")
public class RolesController {

    private final RolesService rolService;

    @GetMapping
    @Operation(
            summary = "Listar roles",
            description = "Retorna todos los roles registrados con su cantidad de usuarios activos.")
    public ResponseEntity<List<RolCategoriaResponseDto>> consultarRoles() {
        return ResponseEntity.ok(rolService.consultarRoles());
    }

    @PostMapping
    @Operation(summary = "Crear rol", description = "Registra un nuevo rol en el sistema.")
    public ResponseEntity<RolResponseDto> crearRol(@Valid @RequestBody RolRequestDto rolRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.crearRol(rolRequest));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar rol", description = "Actualiza los datos de un rol existente.")
    public ResponseEntity<Optional<RolResponseDto>> actualizarRol(
            @PathVariable Long id, @Valid @RequestBody RolRequestDto rolRequest) {
        return ResponseEntity.ok(rolService.actualizarRol(id, rolRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol por ID", description = "Elimina un rol por su identificador.")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRolId(id);
        return ResponseEntity.noContent().build();
    }
}
