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
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> crearUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequest) {

        UsuarioResponseDto crearUsuario = usuarioService.crearUsuario(usuarioRequest);

        return ResponseEntity.ok(crearUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDto>> consultarUsuarioId(@PathVariable Long id) {

        Optional<UsuarioResponseDto> consultarUsuarioId = usuarioService.consultarUsuarioId(id);
        return ResponseEntity.ok(consultarUsuarioId);
    }

    @GetMapping("/buscar-por-ids")
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuariosIds(@RequestParam List<Long> ids) {

        List<UsuarioResponseDto> consultarusuariosIds = usuarioService.consultarUsuariosIds(ids);
        return ResponseEntity.ok(consultarusuariosIds);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuarios() {

        List<UsuarioResponseDto> consultarUsuarios = usuarioService.consultarUsuarios();
        return ResponseEntity.ok(consultarUsuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDto>> actualizarUsuario(
            @PathVariable Long id, @Valid @RequestBody UsuarioRequestDto usuarioRequest) {

        Optional<UsuarioResponseDto> actualizarUsuario = usuarioService.actualizarUsuario(id, usuarioRequest);

        return ResponseEntity.ok(actualizarUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDto>> eliminarUsuarioId(@PathVariable Long id) {

        Optional<UsuarioResponseDto> eliminarUsuarioId = usuarioService.eliminarUsuarioId(id);

        return ResponseEntity.ok(eliminarUsuarioId);
    }

    @DeleteMapping("/eliminar-por-ids")
    public ResponseEntity<List<UsuarioResponseDto>> eliminarUsuariosId(@RequestParam List<Long> ids) {

        List<UsuarioResponseDto> eliminarUsauriosIds = usuarioService.eliminarUsauriosId(ids);

        return ResponseEntity.ok(eliminarUsauriosIds);
    }

    @DeleteMapping
    public ResponseEntity<List<UsuarioResponseDto>> eliminarUsuarios() {

        List<UsuarioResponseDto> eliminarUsuarios = usuarioService.eliminarUsuarios();
        return ResponseEntity.ok(eliminarUsuarios);
    }
}
