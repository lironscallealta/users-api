package cl.duoc.usuarios_api.model;

/*
 * import java.time.LocalDateTime;
 * 
 * import cl.duoc.usuarios_api.model.perfiles.clientes.Cliente;
 * import cl.duoc.usuarios_api.model.perfiles.sistema.Veterinario;
 * import jakarta.persistence.*;
 * import lombok.AllArgsConstructor;
 * import lombok.Data;
 * import lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Entity
 * 
 * @Table(name = "consultas")
 * public class Consulta {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * private Long id;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "veterinario_id", nullable = false)
 * private Veterinario veterinario; // quién atiende
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "cliente_id", nullable = false)
 * private Cliente cliente; // a quién atiende
 * 
 * @Column(name = "fecha_consulta", nullable = false)
 * private LocalDateTime fechaConsulta;
 * 
 * @Column(nullable = false, length = 200)
 * private String motivo; // razón de la consulta
 * 
 * @Column(length = 500)
 * private String diagnostico; // resultado de la consulta
 * 
 * @Column(length = 500)
 * private String tratamiento; // tratamiento indicado
 * 
 * @Column(length = 50)
 * private String estado; // PENDIENTE, EN_CURSO, FINALIZADA, CANCELADA
 * }
 * 
 * // Esto deberia ser otro microservicio...
 * //
 */