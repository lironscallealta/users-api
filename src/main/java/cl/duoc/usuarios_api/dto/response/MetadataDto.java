/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetadataDto {

    private EntityMetadata entity;
    private CategoryMetadata category;
    private DeleteMetadata delete;
    private ActionMetadata action;
    private List<StateMetadata> states;
    private List<ColumnMetadata> columns;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EntityMetadata {
        private String key;
        private String singleLabel;
        private String pluralLabel;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CategoryMetadata {
        private String field;
        private String label;
        private String addTitle;
        private List<String> icons;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeleteMetadata {
        private String nameKey;
        private String detailKey;
        private String detailLabel;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ActionMetadata {
        private String key;
        private String label;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StateMetadata {
        private Long id;
        private String key;
        private String label;
        private String description;

        @JsonProperty("isDefault")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Boolean isDefault;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ColumnMetadata {
        private String key;
        private String label;
        private String type;

        @JsonProperty("isSearchable")
        private boolean isSearchable;

        @JsonProperty("isHidden")
        private boolean isHidden;

        @JsonProperty("isReadOnly")
        private boolean isReadOnly;

        private boolean highlight;

        @JsonProperty("isState")
        private boolean isState;
    }

    // Reference:
    // const metadata = {
    //   entity: { key: "user", singleLabel: "Usuario", pluralLabel: "Usuarios" },
    //   category: {
    //     field: "rol",
    //     label: "Roles",
    //     addTitle: "Nuevo Rol",
    //     icons: ["🐾", "🐕", "🐈", "🐦", "🐹", "📦"],
    //   },
    //   delete: {
    //     nameKey: "nombre",
    //     detailKey: "email",
    //     detailLabel: "Correo",
    //   },
    //   action: { key: "accion", label: "Acciones" },
    //   states: [
    //     {
    //       id: 0,
    //       key: "todos",
    //       label: "Todos los estados",
    //       description: "Todos los estados",
    //       isDefault: true,
    //     },
    //     { id: 1, key: "activo", label: "Activo", description: "..." },
    //     { id: 2, key: "inactivo", label: "Inactivo", description: "..." },
    //     { id: 3, key: "pendiente", label: "En contratación", description: "..." },
    //   ],
    //   columns: [
    //     {
    //       key: "id",
    //       label: "ID",
    //       type: "string",
    //       isSearchable: false,
    //       isHidden: true,
    //       isReadOnly: true,
    //     },
    //     {
    //       key: "nombre",
    //       label: "Usuario",
    //       type: "string",
    //       isSearchable: true,
    //       highlight: true,
    //     },
    //     {
    //       key: "rol",
    //       label: "Rol",
    //       type: "string",
    //       isSearchable: true,
    //     },
    //     {
    //       key: "departamento",
    //       label: "Departamento",
    //       type: "string",
    //     },
    //     {
    //       key: "email",
    //       label: "Correo",
    //       type: "email",
    //       isSearchable: true,
    //     },
    //     {
    //       key: "ultimoLogin",
    //       label: "Último ingreso",
    //       type: "string",
    //       isReadOnly: true,
    //     },
    //     {
    //       key: "estado",
    //       label: "Estado",
    //       type: "string",
    //       isState: true,
    //     },
    //   ],
    // };
}
