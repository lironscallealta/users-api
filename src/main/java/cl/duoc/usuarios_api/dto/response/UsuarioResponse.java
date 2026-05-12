package cl.duoc.usuarios_api.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cl.duoc.usuarios_api.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String dv;
    private String email;
    private String telefonoCelular;
    private LocalDate fechaNacimiento;
    private Rol rol;
    private boolean activo;
    private LocalDateTime fechaCreacion;

}
/*
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * 
 * @Column(nullable = false, length = 50)
 * private String nombre;
 * 
 * @Column(nullable = false, length = 50)
 * private String apellido;
 * 
 * @Column(length = 22)
 * private String rut;
 * 
 * @Column(length = 1)
 * private String dv;
 * 
 * @Column(length = 50, nullable = false, unique = true)
 * private String email;
 * 
 * @Column(length = 20)
 * private String telefonoCelular;
 * 
 * @Column(name = "fecha_nacimiento_usuario", nullable = false)
 * private LocalDate fechaNacimiento;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "rol_id", nullable = false)
 * private Rol rol;
 * 
 * @Column(nullable = false)
 * private boolean activo;
 * 
 * @Column(name = "fecha_creacion_usuario", nullable = false)
 * private LocalDateTime fechaCreacion;
 */