/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.controller;

import cl.duoc.usuarios_api.dto.request.UsuarioRequestDto;
import cl.duoc.usuarios_api.dto.response.UsuarioResponseDto;
import cl.duoc.usuarios_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crearUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearUsuario(usuarioRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDto>> consultarUsuarioId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.consultarUsuarioId(id));
    }

    @GetMapping("/buscar-por-ids")
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuariosIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(usuarioService.consultarUsuariosIds(ids));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuarios() {
        return ResponseEntity.ok(usuarioService.consultarUsuarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDto>> actualizarUsuario(
            @PathVariable Long id, @Valid @RequestBody UsuarioRequestDto usuarioRequest) {
        return ResponseEntity.ok(usuarioService.actualizarUsuario(id, usuarioRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioId(@PathVariable Long id) {
        usuarioService.eliminarUsuarioId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/eliminar-por-ids")
    public ResponseEntity<Void> eliminarUsuariosIds(@RequestParam List<Long> ids) {
        usuarioService.eliminarUsuariosIds(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarUsuarios() {
        usuarioService.eliminarUsuarios();
        return ResponseEntity.noContent().build();
    }
}
