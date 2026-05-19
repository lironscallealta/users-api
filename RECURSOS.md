# Recursos — Users-API (Usuarios)

Solo enlaces de **este** microservicio. Cada API tiene su propio phpMyAdmin en otro puerto.

## phpMyAdmin — base de datos `users`

### Levantar servicios

Desde la carpeta `users-api`:

```bash
docker compose up db phpmyadmin -d
```

### Abrir (solo este enlace)

**[http://localhost:8191](http://localhost:8191)**

### Iniciar sesión

| Campo | Valor |
|-------|--------|
| Usuario | `user` |
| Contraseña | `password` |

### Comprobar que es la BD correcta

En el panel izquierdo de phpMyAdmin debe aparecer la base **`users`**.  
Si ves `pets` o `vets`, abriste el puerto equivocado (8190 o 8192).

---

## MySQL directo (DBeaver, Workbench)

| Parámetro | Valor |
|-----------|--------|
| Host | `localhost` |
| Puerto | `3391` |
| Base de datos | `users` |
| Usuario | `user` |
| Contraseña | `password` |

---

## Otros microservicios (no uses estos enlaces aquí)

| Microservicio | phpMyAdmin | Base de datos |
|---------------|------------|---------------|
| Pets | `http://localhost:8190` | `pets` |
| Vets | `http://localhost:8192` | `vets` |

Documentación en `pets-api/RECURSOS.md` y `vets-api/RECURSOS.md`.

---

## Swagger (solo con Spring en ejecución)

[http://localhost:8091/swagger-ui/index.html](http://localhost:8091/swagger-ui/index.html)
