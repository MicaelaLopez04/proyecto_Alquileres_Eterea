# 🏠 Eterea - Plataforma de Alquileres

Proyecto académico desarrollado para practicar arquitectura de microservicios utilizando Spring Boot.

La aplicación permite gestionar departamentos para alquiler mediante distintos roles de usuario y separación de responsabilidades entre servicios.

---

## Estado del proyecto

🚧 En desarrollo

Actualmente se encuentra implementado principalmente el backend.

Pendiente:

* Completar frontend
* Implementar autenticación y autorización
* Finalizar flujo de roles
* Mejorar experiencia de usuario

---

## Tecnologías utilizadas

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Maven
* MySQL

### Frontend

* HTML
* CSS
* JavaScript

---

## Arquitectura

El sistema está dividido en microservicios independientes.

### Usuarios Service (Puerto 8081)

Responsabilidades:

* Gestión de usuarios
* Manejo de roles
* Información del perfil

### Departamentos Service (Puerto 8080)

Responsabilidades:

* Alta de departamentos
* Actualización de información
* Consulta de publicaciones

### Reservas Service (Puerto 8082)

Responsabilidades:

* Gestión de reservas
* Solicitudes de alquiler
* Flujo entre dueño e inquilino

---

## Roles del sistema

### Inquilino

Puede:

* Visualizar departamentos
* Solicitar alquileres
* Dejar reseñas o comentarios

### Dueño

Puede:

* Publicar departamentos
* Editar información
* Aceptar o rechazar solicitudes

---

## Estructura del proyecto

```plaintext
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

* Java 17
* Maven
* MySQL
* Spring Tool Suite / IntelliJ
* Postman

### Base de datos

Crear previamente:

* alquileres_db
* usuarios_db
* reservas_db

### Pasos

1. Clonar el repositorio
2. Crear las bases de datos
3. Configurar `application.properties`
4. Ejecutar cada microservicio
5. Abrir el frontend

---

## Microservicios

Levantar cada servicio por separado:

1. departamentos-service → puerto 8080
2. usuarios-service → puerto 8081
3. reservas-service → puerto 8082

---

# Endpoints para pruebas (Postman)

## Departamentos Service (8080)

### Obtener todos

GET
http://localhost:8080/departamentos

### Obtener por ID

GET
http://localhost:8080/departamentos/1

### Crear departamento

POST
http://localhost:8080/departamentos

Body:

```json
{
  "nombre": "Departamento Centro",
  "capacidad": 4,
  "descripcion": "Departamento amplio",
  "precio": 70000,
  "direccion": "Av Principal 123"
}
```

### Actualizar

PUT
http://localhost:8080/departamentos/1

### Eliminar

DELETE
http://localhost:8080/departamentos/1

---

## Usuarios Service (8081)

### Obtener usuarios

GET
http://localhost:8081/usuarios

### Obtener usuario por ID

GET
http://localhost:8081/usuarios/1

### Buscar por email

GET
http://localhost:8081/usuarios/email?email=ejemplo@gmail.com

### Crear usuario

POST
http://localhost:8081/usuarios

Body:

```json
{
  "nombre": "Micaela",
  "apellido": "Lopez",
  "edad": 23,
  "email": "mica@gmail.com",
  "password": "1234",
  "rol": "Inquilino"
}
```

Valores posibles:

* Dueño
* Inquilino

### Actualizar

PUT
http://localhost:8081/usuarios/1

### Eliminar

DELETE
http://localhost:8081/usuarios/1

---

## Reservas Service (8082)

### Obtener reservas

GET
http://localhost:8082/reservas

### Obtener reserva por ID

GET
http://localhost:8082/reservas/1

### Crear reserva

POST
http://localhost:8082/reservas

Body:

```json
{
  "fechaInicio": "2026-06-23",
  "fechaFin": "2026-06-28",
  "cantidadPersonas": 2,
  "descripcion": "Vacaciones",
  "usuarioId": 1,
  "departamentoId": 1
}
```

Estados posibles:

* Pendiente
* Aceptada
* Rechazada

### Aceptar reserva

PUT
http://localhost:8082/reservas/1/aceptar

### Rechazar reserva

PUT
http://localhost:8082/reservas/1/rechazar

### Eliminar

DELETE
http://localhost:8082/reservas/1

---

## Objetivo del proyecto

El objetivo fue aprender:

* Arquitectura de microservicios
* Diseño de APIs REST
* Comunicación entre servicios
* Organización de proyectos backend grandes

---

Desarrollado como proyecto personal de aprendizaje

