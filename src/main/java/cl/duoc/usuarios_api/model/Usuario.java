package cl.duoc.usuarios_api.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String run;
    private String dv;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String rol; // "VETERINARIO", "SECRETARIA", etc.
    private boolean activo; // si el usuario está habilitado
    private LocalDateTime fechaCreacion;
}
