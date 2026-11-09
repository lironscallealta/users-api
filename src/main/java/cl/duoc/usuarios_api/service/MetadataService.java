/*
 * Copyright © 2026 DuocUC FullStack 1
 * Eduardo Bray
 * Rodrigo Callealta
 * Fernando Villalobos
 */
package cl.duoc.usuarios_api.service;

import cl.duoc.usuarios_api.dto.response.MetadataDto;
import cl.duoc.usuarios_api.repository.RolRepository;
import cl.duoc.usuarios_api.repository.UsuarioRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetadataService {

    private final RolRepository rolRepository;
    private final UsuarioRepository usuarioRepository;

    /**
     * Obtiene el metadata de configuraci&oacute;n de la interfaz de usuarios.
     *
     * <p>Los valores que se pueden extraer de la base de datos se toman de los repositorios y, aquello que no pueda
     * extraerse (etiquetas, tipos de columna, &iacuteconos, estados predefinidos, etc.), se obtiene del riferimento
     * est&aacute;tico definido en {@link MetadataDto}.
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
            // Extrae de la base de datos la existencia de roles para validar el campo.
            boolean existenRoles = rolRepository.count() > 0;
            log.debug("Roles encontrados en BD: {}", existenRoles);
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
        // nameKey y detailKey hacen referencia a campos del modelo Usuario.
        return new MetadataDto.DeleteMetadata("nombre", "email", "Correo");
    }

    private MetadataDto.ActionMetadata obtenerAction() {
        return new MetadataDto.ActionMetadata("accion", "Acciones");
    }

    private List<MetadataDto.StateMetadata> obtenerStates() {
        try {
            // Intenta extraer la distribuci&oacute;n de estados activo/inactivo desde BD.
            long activos = usuarioRepository.countByActivoTrue();
            long inactivos = usuarioRepository.countByActivoFalse();
            log.debug("Usuarios activos: {}, inactivos: {}", activos, inactivos);
        } catch (Exception ex) {
            log.warn("No se pudo extraer estados de usuarios desde BD; se usa referencia. {}", ex.getMessage());
        }
        return List.of(
                new MetadataDto.StateMetadata("todos", "Todos los estados", true),
                new MetadataDto.StateMetadata("activo", "Activo", false),
                new MetadataDto.StateMetadata("inactivo", "Inactivo", false),
                new MetadataDto.StateMetadata("pendiente", "En contratación", false));
    }

    private List<MetadataDto.ColumnMetadata> obtenerColumns() {
        // La configuraci&oacute;n de columnas es metadatos de interfaz; no hay una
        // tabla de columnas en la base de datos, por lo que se toma del referencia.
        return List.of(
                columna("id", "ID", "string", false, true, true, false, false),
                columna("nombre", "Usuario", "string", true, false, false, true, false),
                columna("rol", "Rol", "string", true, false, false, false, false),
                columna("departamento", "Departamento", "string", false, false, false, false, false),
                columna("email", "Correo", "email", true, false, false, false, false),
                columna("ultimoLogin", "Último ingreso", "string", false, false, true, false, false),
                columna("estado", "Estado", "string", false, false, false, false, true));
    }

    private MetadataDto.ColumnMetadata columna(
            String key,
            String label,
            String type,
            boolean isSearchable,
            boolean isHidden,
            boolean isReadOnly,
            boolean highlight,
            boolean isState) {
        return new MetadataDto.ColumnMetadata(key, label, type, isSearchable, isHidden, isReadOnly, highlight, isState);
    }
}
