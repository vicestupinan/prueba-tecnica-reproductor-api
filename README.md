# Backend - Prueba Técnica Playlist API

Este proyecto es una API RESTful construida con **Spring Boot** que permite gestionar listas de reproducción y sus canciones.
- Frontend: [prueba-tecnica-reproductor-front](https://github.com/vicestupinan/prueba-tecnica-reproductor-front)

---

## 🚀 Características

- Crear, listar, buscar y eliminar listas de reproducción musicales.
- Cada lista puede contener múltiples canciones.
- Validaciones de datos (nombre obligatorio, nombre único).
- Autenticación con Basic Auth.
- Persistencia en base de datos en memoria (H2).
- Configuración de CORS para uso con frontend Angular.
- Pruebas unitarias con JUnit.

---

## 🧰 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5
- Spring Web / Spring Security
- Spring Data JPA
- H2 Database (modo memoria)
- Lombok
- JUnit 5

---

## ⚙️ Requisitos previos

- Java 17 o superior
- Maven 3.8+

---

## 🔧 Instalación y ejecución

```bash
git clone https://github.com/tu-usuario/prueba-tecnica-reproductor-api.git
cd prueba-tecnica-reproductor-api

./mvnw spring-boot:run
```
---

## Endpoints

| Método | Endpoint              | Descripción                   |
| ------ | --------------------- | ----------------------------- |
| GET    | `/lists`              | Obtener todas las listas      |
| GET    | `/lists/{nombre}`     | Buscar una lista por nombre   |
| POST   | `/lists`              | Crear nueva lista             |
| DELETE | `/lists/{nombre}`     | Eliminar una lista por nombre |

---

## 🧪 Pruebas unitarias

./mvnw test