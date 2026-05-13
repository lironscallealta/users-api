# Diagrama de Base de Datos - Usuarios API

Este diagrama se genera automáticamente con Mermaid.
Solo es texto, pero GitHub y VS Code lo muestran como gráfico.

```mermaid
erDiagram
    USUARIOS {
        Long id PK
        String nombre
        String apellido
        String email
        String rol
    }

    VETERINARIOS {
        Long id PK
        Long usuario_id FK
        String horarioAtencion
    }

    CLIENTES {
        Long id PK
        Long usuario_id FK
        String direccion
        String comuna
    }

    USUARIOS ||--o{ VETERINARIOS : "tiene perfil"
    USUARIOS ||--o{ CLIENTES : "tiene perfil"
```

## ¿Cómo funciona?

Todo lo de arriba es **texto plano**. Las reglas son:

1. Abres con triple backtick + la palabra `mermaid`
2. Escribes `erDiagram` para indicar que es un diagrama ER
3. Defines tablas con `NOMBRE_TABLA { tipo campo }`
4. Marcas claves con `PK` (Primary Key) o `FK` (Foreign Key)
5. Defines relaciones con flechas: `TABLA1 ||--o{ TABLA2 : "descripción"`
6. Cierras con triple backtick

### Tipos de relaciones:
- `||--||` = uno a uno
- `||--o{` = uno a muchos
- `o{--o{` = muchos a muchos
