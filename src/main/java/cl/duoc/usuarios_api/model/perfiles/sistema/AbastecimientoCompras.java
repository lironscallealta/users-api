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
@Table(name = "abastecimiento_compras")
public class AbastecimientoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razon_social", nullable = false, length = 200)
    private String razonSocial; // nombre legal de la empresa proveedora

    @Column(name = "rut_empresa", nullable = false, length = 20)
    private String rutEmpresa;

    @Column(name = "dv_empresa", nullable = false, length = 1)
    private String dvEmpresa;

    @Column(length = 100)
    private String giro; // rubro del proveedor

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @Column(name = "tipo_producto", length = 100)
    private String tipoProducto; // categoría: medicamentos, alimentos, insumos, etc.

    @Column(name = "nombre_producto", length = 200)
    private String nombreProducto; // producto que provee

    @Column(name = "contacto_comercial", length = 100)
    private String contactoComercial; // persona de contacto en la empresa

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
