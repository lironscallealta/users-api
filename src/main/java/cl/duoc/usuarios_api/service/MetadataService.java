/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.response.MetadataDto;
import cl.duoc.usuarios_api.model.ColumnMetadata;
import cl.duoc.usuarios_api.model.EstadoUsuario;
import cl.duoc.usuarios_api.repository.ColumnMetadataRepository;
import cl.duoc.usuarios_api.repository.EstadoUsuarioRepository;
import cl.duoc.usuarios_api.repository.RolRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetadataService {

    private static final String TABLA_USUARIOS = "usuarios";

    private final RolRepository rolRepository;
    private final EstadoUsuarioRepository estadoUsuarioRepository;
    private final ColumnMetadataRepository columnMetadataRepository;

    /**
     * Obtiene el metadata de configuración de la interfaz de usuarios.
     *
     * <p>Los valores que se pueden extraer de la base de datos se toman de los repositorios y, aquello que no pueda
     * extraerse (etiquetas de entidad, categoría, acciones, etc.), se obtiene de la referencia estática definida en
     * {@link MetadataDto}.
     */
    @Transactional(readOnly = true)
    public MetadataDto obtenerMetadata() {
        MetadataDto metadata = new MetadataDto();

        metadata.setEntity(obtenerEntity());
        metadata.setCategory(obtenerCategory());
        metadata.setDelete(obtenerDelete());
        metadata.setAction(obtenerAction());
        metadata.setStates(obtenerStates());
        metadata.setColumns(obtenerColumns());

        return metadata;
    }

    private MetadataDto.EntityMetadata obtenerEntity() {
        return new MetadataDto.EntityMetadata("user", "Usuario", "Usuarios");
    }

    private MetadataDto.CategoryMetadata obtenerCategory() {
        String field = "rol";
        try {
            boolean existenRoles = rolRepository.count() > 0;
            if (!existenRoles) {
                log.warn("No hay roles registrados en BD; se usa el valor de referencia para category.field");
            }
        } catch (Exception ex) {
            log.warn("No se pudo extraer category de BD; se usa referencia. {}", ex.getMessage());
        }
        return new MetadataDto.CategoryMetadata(
                field, "Roles", "Nuevo Rol", List.of("🐾", "🐕", "🐈", "🐦", "🐹", "📦"));
    }

    private MetadataDto.DeleteMetadata obtenerDelete() {
        return new MetadataDto.DeleteMetadata("nombre", "email", "Correo");
    }

    private MetadataDto.ActionMetadata obtenerAction() {
        return new MetadataDto.ActionMetadata("accion", "Acciones");
    }

    private List<MetadataDto.StateMetadata> obtenerStates() {
        List<MetadataDto.StateMetadata> states = new ArrayList<>();
        states.add(new MetadataDto.StateMetadata(0L, "todos", "Todos los estados", "Todos los estados", Boolean.TRUE));

        List<EstadoUsuario> estados = estadoUsuarioRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        for (EstadoUsuario estado : estados) {
            states.add(new MetadataDto.StateMetadata(
                    estado.getId(),
                    estado.getNombre(),
                    obtenerLabelEstado(estado.getNombre()),
                    estado.getDescripcion(),
                    null));
        }

        return states;
    }

    private String obtenerLabelEstado(String nombre) {
        return switch (nombre) {
            case "activo" -> "Activo";
            case "inactivo" -> "Inactivo";
            case "pendiente" -> "En contratación";
            default -> nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
        };
    }

    private List<MetadataDto.ColumnMetadata> obtenerColumns() {
        List<ColumnMetadata> columnas =
                columnMetadataRepository.findAllByTableNameOrderBySortOrderAscIdAsc(TABLA_USUARIOS);

        if (columnas.isEmpty()) {
            log.warn("No hay columnas de metadata registradas para la tabla {}", TABLA_USUARIOS);
        }

        return columnas.stream()
                .map(columna -> new MetadataDto.ColumnMetadata(
                        columna.getApiKey(),
                        columna.getLabel(),
                        columna.getType(),
                        columna.isShowInCreate(),
                        columna.isShowInEdit(),
                        columna.isRequired(),
                        columna.isReadOnly(),
                        columna.isSearchable(),
                        columna.isHidden(),
                        columna.isHighlight(),
                        columna.isState()))
                .toList();
    }
}
