/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Datos retornados por la API para un usuario del sistema.")
public class UsuarioResponseDto {

    @Schema(description = "Identificador único del usuario", example = "104")
    private Long id;

    @Schema(description = "Nombre o nombres de pila del usuario", example = "Camila")
    private String nombre;

    @Schema(description = "Apellido o apellidos del usuario", example = "Valdés Soto")
    private String apellido;

    @Schema(description = "Nombre completo del usuario", example = "Camila Valdés Soto")
    private String nombreCompleto;

    @Schema(description = "Cuerpo numérico del RUT del usuario, sin puntos ni dígito verificador", example = "18456789")
    private String rut;

    @Schema(description = "Dígito verificador del RUT", example = "K")
    private String dv;

    @Schema(description = "Fecha de nacimiento del usuario", example = "1993-08-15")
    private LocalDate fechaNacimiento;

    @Schema(description = "Correo electrónico de contacto e inicio de sesión", example = "camila.valdes@petcare.cl")
    private String email;

    @Schema(description = "Edad actual del usuario en años", example = "33")
    private Integer edad;

    @Schema(description = "Número de teléfono celular de contacto", example = "+56987654321")
    private String telefonoCelular;

    @Schema(description = "Área o departamento al que pertenece el usuario interno", example = "Clínica Veterinaria")
    private String departamento;

    @Schema(description = "Identificador del rol asignado (ej. Cliente, Vendedor, Médico Veterinario)", example = "2")
    private Long rolId;

    @Schema(description = "Identificador del estado actual de la cuenta del usuario", example = "1")
    private Long estadoId;

    @Schema(description = "Fecha y hora del último inicio de sesión registrado", example = "2026-11-22T18:30:00")
    private LocalDateTime ultimoLogin;
}
