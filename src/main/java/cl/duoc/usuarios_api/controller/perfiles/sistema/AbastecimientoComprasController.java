package cl.duoc.usuarios_api.controller.perfiles.sistema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.usuarios_api.service.perfiles.sistema.AbastecimientoComprasService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/usuarios/sistema/abastecimiento-compras")
@RequiredArgsConstructor
public class AbastecimientoComprasController {

    private final AbastecimientoComprasService abastecimientoComprasService;

}
