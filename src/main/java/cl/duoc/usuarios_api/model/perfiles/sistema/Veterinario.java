package cl.duoc.usuarios_api.model.perfiles.sistema;

import cl.duoc.usuarios_api.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "horario_atencion", length = 100)
    private String horarioAtencion; // ej: "Lunes a Viernes 09:00-18:00"
}