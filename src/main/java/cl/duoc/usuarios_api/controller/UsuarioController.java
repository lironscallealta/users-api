package cl.duoc.usuarios_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios_api.dto.request.UsuarioRequestDto;
import cl.duoc.usuarios_api.dto.response.UsuarioResponseDto;
import cl.duoc.usuarios_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<UsuarioResponseDto> crearUsuario(UsuarioRequestDto usuarioRequest) {

        UsuarioResponseDto crearUsuario = usuarioService.crearUsuario(usuarioRequest);

        return ResponseEntity.ok(crearUsuario);

    }

    @GetMapping
    public ResponseEntity<Optional<UsuarioResponseDto>> consultarUsuarioId(Long id) {

        Optional<UsuarioResponseDto> consultarUsuarioId = usuarioService.consultarUsuarioId(id);
        return ResponseEntity.ok(consultarUsuarioId);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> consultarUsuarios() {

        List<UsuarioResponseDto> consultarUsuarios = usuarioService.consultarUsuarios();
        return ResponseEntity.ok(consultarUsuarios);
    }

}
// | Create | POST | `/api/v1/users`

// | Get one | GET | `/api/v1/users/{id}` |
// | Get all | GET | `/api/v1/users` |
// metodo prueba en caso de usarlo seria por el get all anterior

// | Get all | GET | `/api/v1/users/getdos` |
// | Delete | DELETE | `/api/v1/users/{id}` |