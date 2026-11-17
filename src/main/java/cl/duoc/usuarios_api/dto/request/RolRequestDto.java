/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolRequestDto {

    @NotBlank
    @Size(min = 1, max = 50)
    private String nombreRol;

    @NotBlank
    @Size(min = 1, max = 50)
    private String nombreMostrar;

    @NotBlank
    @Size(min = 1, max = 4)
    private String icon;

    @NotBlank
    @Size(min = 1, max = 255)
    private String descripcion;
}
