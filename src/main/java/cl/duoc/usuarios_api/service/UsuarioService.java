package cl.duoc.usuarios_api.service;

import org.springframework.stereotype.Service;

import cl.duoc.usuarios_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

}
