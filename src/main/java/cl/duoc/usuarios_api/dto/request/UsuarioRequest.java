package cl.duoc.usuarios_api.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    @Size(min = 5, max = 10)
    private String rut;

    @NotBlank
    @Size(min = 1, max = 1)
    private String dv;

    @Email
    @NotBlank
    private String email;

    @Size(min = 7, max = 15)
    private String telefonoCelular;

    @Past
    private LocalDate fechaNacimiento;

    @NotNull
    private Long rol;

    @NotNull
    private boolean activo;

    /*
     * @PastOrPresent
     * 
     * @NotNull
     * private LocalDateTime fechaCreacion;
     */
    // La fecha de creación se establecerá automáticamente con local now...

}
