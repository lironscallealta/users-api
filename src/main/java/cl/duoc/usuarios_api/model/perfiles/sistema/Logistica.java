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
@Table(name = "logistica")
public class Logistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zona_asignada_direccion", nullable = false, length = 100)
    private String zonaAsignadaDireccion; // zona geográfica de despacho

    @Column(name = "bodega_asignada_direccion", length = 100)
    private String bodegaAsignadaDireccion; // bodega que gestiona (entradas/salidas)

    @Column(name = "vehiculo_asignado", length = 100)
    private String vehiculoAsignadoPatente; // vehículo para entregas

    @Column(name = "licencia_conducir", length = 20)
    private String licenciaConducir; // clase B, A2, etc.

    @Column(length = 50)
    private String turno; // mañana, tarde, completo

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
