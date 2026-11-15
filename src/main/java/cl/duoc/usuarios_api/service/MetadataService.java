/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.response.MetadataDto;
import cl.duoc.usuarios_api.model.ColumnMetadata;
import cl.duoc.usuarios_api.model.EntityMetadata;
import cl.duoc.usuarios_api.model.EstadoUsuario;
import cl.duoc.usuarios_api.repository.ColumnMetadataRepository;
import cl.duoc.usuarios_api.repository.EntityMetadataRepository;
import cl.duoc.usuarios_api.repository.EstadoUsuarioRepository;
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

    private final EntityMetadataRepository entityMetadataRepository;
    private final EstadoUsuarioRepository estadoUsuarioRepository;
    private final ColumnMetadataRepository columnMetadataRepository;

    /**
     * Obtiene el metadata de configuración de la interfaz de usuarios.
     *
     * <p>La configuración de entidad, columnas y estados se obtiene desde la base de datos.
     */
    @Transactional(readOnly = true)
    public MetadataDto obtenerMetadata() {
        EntityMetadata entityMetadata = obtenerEntityMetadata();
        MetadataDto metadata = new MetadataDto();

        metadata.setEntity(obtenerEntity(entityMetadata));
        metadata.setCategory(obtenerCategory(entityMetadata));
        metadata.setDelete(obtenerDelete(entityMetadata));
        metadata.setAction(obtenerAction(entityMetadata));
        metadata.setStates(obtenerStates());
        metadata.setColumns(obtenerColumns());

        return metadata;
    }

    private EntityMetadata obtenerEntityMetadata() {
        return entityMetadataRepository
                .findByTableName(TABLA_USUARIOS)
                .orElseThrow(
                        () -> new IllegalStateException("No hay metadata de entidad para la tabla " + TABLA_USUARIOS));
    }

    private MetadataDto.EntityMetadata obtenerEntity(EntityMetadata entityMetadata) {
        return new MetadataDto.EntityMetadata(
                entityMetadata.getEntityKey(), entityMetadata.getSingleLabel(), entityMetadata.getPluralLabel());
    }

    private MetadataDto.CategoryMetadata obtenerCategory(EntityMetadata entityMetadata) {
        return new MetadataDto.CategoryMetadata(
                entityMetadata.getCategoryField(),
                entityMetadata.getCategoryLabel(),
                entityMetadata.getCategoryAddTitle(),
                entityMetadata.getCategoryIcons());
    }

    private MetadataDto.DeleteMetadata obtenerDelete(EntityMetadata entityMetadata) {
        return new MetadataDto.DeleteMetadata(
                entityMetadata.getDeleteNameKey(),
                entityMetadata.getDeleteDetailKey(),
                entityMetadata.getDeleteDetailLabel());
    }

    private MetadataDto.ActionMetadata obtenerAction(EntityMetadata entityMetadata) {
        return new MetadataDto.ActionMetadata(entityMetadata.getActionKey(), entityMetadata.getActionLabel());
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
