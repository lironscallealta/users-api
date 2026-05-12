package cl.duoc.usuarios_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDto {

    private Long id;
    private String nombreCompleto;
    private String rut;
    private String email;
    private int edad;
    private String telefonoCelular;
    private RolResponseDto rol;
    private boolean activo;

}
/*
 * ---------------Datos en bruto------------
 * private Long id;
 * private String nombre;
 * private String apellido;
 * private String rut;
 * private String dv;
 * private String email;
 * private String telefonoCelular;
 * private LocalDate fechaNacimiento;
 * private Rol rol;
 * private boolean activo;
 * private LocalDateTime fechaCreacion;
 */