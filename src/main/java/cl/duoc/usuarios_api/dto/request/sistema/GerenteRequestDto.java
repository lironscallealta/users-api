package cl.duoc.usuarios_api.dto.request.sistema;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GerenteRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
    private String apellido;

    @Email(message = "El email debe ser un correo electrónico válido")
    @NotBlank
    private String email;

    @Pattern(regexp = "^[0-9]{7,8}$", message = "El rut debe tener 7 a 8 digitos")
    @NotBlank(message = "El rut es obligatorio")
    private String rut;

    @NotBlank(message = "El dv es obligatorio")
    @Pattern(regexp = "^[0-9kK]{1}$")
    private String dv;

    @Pattern(regexp = "^[0-9]{8}$", message = "El telefono debe tener 8 o 9 digitos")
    private String telefonoCelular;

    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    @NotBlank
    private String sucursal;

    @NotBlank
    private String turno;

}
