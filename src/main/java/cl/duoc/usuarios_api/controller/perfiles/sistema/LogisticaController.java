package cl.duoc.usuarios_api.controller.perfiles.sistema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios_api.service.perfiles.sistema.LogisticaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/usuarios/sistema/logistica")
@RequiredArgsConstructor
public class LogisticaController {

    private final LogisticaService logisticaService;

}
