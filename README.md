# 🏠 Eterea - Plataforma de Alquileres

Proyecto académico desarrollado para practicar arquitectura de microservicios utilizando Spring Boot.

La aplicación permite gestionar departamentos para alquiler mediante distintos roles de usuario y separación de responsabilidades entre servicios.

## Estado del proyecto

🚧 En desarrollo

Actualmente se encuentra implementado principalmente el backend.  
Pendiente:
- Completar frontend
- Implementar autenticación y autorización
- Finalizar flujo de roles
- Mejorar experiencia de usuario

---

## Tecnologías utilizadas

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL

### Frontend
- HTML
- CSS
- JavaScript

---

## Arquitectura

El sistema está dividido en microservicios independientes.

### Usuarios Service (Puerto 8081)
Responsabilidades:
- Gestión de usuarios
- Manejo de roles
- Información del perfil

### Departamentos Service (Puerto 8080)
Responsabilidades:
- Alta de departamentos
- Actualización de información
- Consulta de publicaciones

### Reservas Service (Puerto 8082)
Responsabilidades:
- Gestión de reservas
- Solicitudes de alquiler
- Flujo entre dueño e inquilino

---

## Roles del sistema

### Inquilino
Puede:
- Visualizar departamentos
- Solicitar alquileres
- Dejar reseñas o comentarios

### Dueño
Puede:
- Publicar departamentos
- Editar información
- Aceptar o rechazar solicitudes

---

## Estructura del proyecto

```
frontend/

departamentos-service/
 ├── controller
 ├── service
 ├── repository
 └── model

usuarios-service/
 ├── controller
 ├── service
 ├── repository
 └── model

reservas-service/
 ├── controller
 ├── service
 ├── repository
 └── model
```

---

## Cómo ejecutar el proyecto

### Requisitos
- Java 17
- Maven
- MySQL
- IDE (IntelliJ o Spring Tool Suite)

### Pasos
1. Clonar el repositorio
2. Crear la base de datos en MySQL
3. Configurar `application.properties`
4. Ejecutar cada microservicio
5. Abrir el frontend

---

## Objetivo del proyecto

El objetivo fue aprender:
- Arquitectura de microservicios
- Diseño de APIs REST
- Comunicación entre servicios
- Organización de proyectos backend grandes

---

Desarrollado como proyecto personal de aprendizaje.
