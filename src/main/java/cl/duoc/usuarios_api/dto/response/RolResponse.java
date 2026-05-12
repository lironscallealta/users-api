package cl.duoc.usuarios_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolResponse {

    private Long id;
    private String nombreRol;
    private String descripcion;
}
