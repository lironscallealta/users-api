package cl.duoc.usuarios_api.controller.perfiles.sistema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios_api.service.perfiles.sistema.GerenteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/usuarios/sistema/gerente")
@RequiredArgsConstructor
public class GerenteController {

    private final GerenteService gerenteService;

}
