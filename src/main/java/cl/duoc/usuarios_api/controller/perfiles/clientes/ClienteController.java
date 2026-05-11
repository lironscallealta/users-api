package cl.duoc.usuarios_api.controller.perfiles.clientes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios_api.service.perfiles.clientes.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/usuarios/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

}
