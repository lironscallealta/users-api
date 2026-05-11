package cl.duoc.usuarios_api.model.perfiles.clientes;

import cl.duoc.usuarios_api.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes_mayoristas")
public class ClienteMayorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social", nullable = false, length = 200)
    private String razonSocial; // nombre legal de la empresa

    @Column(nullable = false, length = 100)
    private String giro; // rubro comercial

    @Column(name = "rut_empresa", nullable = false, length = 20)
    private String rutEmpresa;

    @Column(name = "dv_empresa", nullable = false, length = 1)
    private String dvEmpresa;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
