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
@Table(name = "gerentes")
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(length = 100)
    private String sucursal;

    @Column(length = 50)
    private String turno; // mañana, tarde, completo
}
