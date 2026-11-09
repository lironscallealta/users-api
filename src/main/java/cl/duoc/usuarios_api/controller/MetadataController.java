/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.controller;

import cl.duoc.usuarios_api.dto.response.MetadataDto;
import cl.duoc.usuarios_api.service.MetadataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Metadata", description = "Metadatos de configuraci&oacute;n de la interfaz de usuarios.")
public class MetadataController {

    private final MetadataService metadataService;

    @GetMapping("/metadata")
    @Operation(
            summary = "Obtener metadata de usuarios",
            description =
                    "Retorna la configuraci&oacute;n de metadata (entidad, categor&iacute;a, estados, columnas, etc.) "
                            + "esperada por el frontend para renderizar el listado de usuarios.")
    public ResponseEntity<MetadataDto> obtenerMetadata() {
        return ResponseEntity.ok(metadataService.obtenerMetadata());
    }
}
