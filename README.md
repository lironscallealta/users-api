# Users Microservice (users-api v1)

## Descripción

Microservicio encargado de la **gestión de usuarios** dentro del ecosistema de VetDistribuidora SPA. Permite registrar y gestionar distintos tipos de usuarios como clientes (minoristas y mayoristas), empleados, y veterinarios. Sirve como base para la autenticación y referencia de dueños de mascotas.

Este microservicio forma parte de una arquitectura distribuida para la transformación digital de VetDistribuidora SPA.

## Tech Stack

### Infraestructura:

- [Java 25 LTS](https://docs.oracle.com/en/java/javase/25/): Última versión Java LTS.
- [Spring Boot v4.0.6](https://github.com/spring-projects/spring-boot): Última versión estable.
- [Docker](https://docs.docker.com/) & [Docker Compose](https://docs.docker.com/compose/): Contenedorización y entorno de desarrollo.
- [MySQL v8.4 LTS](https://hub.docker.com/_/mysql): Base de datos relacional.

### Dependencias:

1. **Lombok:** Reducción de boilerplate
2. **Validation:** Validación de beans
3. **Spring Boot DevTools:** Autoreload
4. **Spring WebMVC:** Capacidades REST
5. **Spring WebFlux:** Para comunicación inter-microservicios
6. **Spring Data JPA:** ORM para manejo de entidades
7. **MySQL Connector:** Driver de base de datos
8. **Flyway Migration:** Migraciones versionadas
9. **Spotless (Palantir):** Autoformateador de código

## Estructura del Proyecto

```
src/main/java/cl/duoc/usuarios_api/
├── UsuariosApiApplication.java
├── controller/                      # Endpoints REST
├── dto/                             # DTOs request/response
├── model/                           # Entidades JPA (Usuario, Rol, etc.)
├── repository/                      # Repositorios JPA
└── service/                         # Lógica de negocio
```

## Entorno de Desarrollo

### 1. Configurar variables de entorno

Crear un archivo `.env` a partir del ejemplo proporcionado:

```bash
cp .env.example .env
```

Variables principales del `.env`:

```yaml
SPRING_ENV=dev
SPRING_APP_NAME=UsuariosMicroservice
HOST_PORT=8081
HOST_DB_PORT=3310
MYSQL_DATABASE=usuarios
MYSQL_HOST=localhost
MYSQL_USER=user
MYSQL_PASSWORD=password
MYSQL_ROOT_PASSWORD=root_password
PHPMYADMIN_PORT=8091
```

### 2. Levantar la base de datos

```bash
docker compose up -d
```

### 3. Verificar BD vía phpMyAdmin

- Ir a [http://localhost:8091](http://localhost:8091)
- Usar las credenciales definidas en `.env`.

### 4. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8081/api/v1/usuarios` (o la ruta que hayas configurado). Swagger estará en `http://localhost:8081/swagger-ui/index.html`.

## Equipo

- Eduardo Bray
- Rodrigo Callealta
- Fernando Villalobos

## Microservicio Desarrollado Por Rodrigo Callealta

- user github = lironscallealta

> **DuocUC — FullStack 1 © 2026**
