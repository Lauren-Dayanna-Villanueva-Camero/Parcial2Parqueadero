# Sistema de Gestión de Parqueadero

Aplicación web desarrollada con Spring Boot para la gestión de entradas y salidas de un parqueadero con control de roles y permisos.

## Descripción

Sistema que permite gestionar registros de vehículos en un parqueadero con tres roles de usuario:

- **ADMINISTRADOR**: CRUD completo de registros y tipos de vehículo
- **ACOMODADOR**: Visualizar y actualizar ubicaciones de vehículos
- **CLIENTE**: Solo visualizar registros

## Tecnologías

- Java 21+
- Spring Boot 3.5.7
- Spring Security
- Spring Data JPA
- PostgreSQL
- JSP + JSTL
- Maven
- Swagger/OpenAPI
- Lombok
- Bootstrap 5

## Requisitos Previos

- JDK 21 o superior
- Maven 3.6+
- PostgreSQL 12+
- IDE Java (IntelliJ, Eclipse, VS Code)

## Instalación y Configuración

### 1. Clonar el repositorio
https://github.com/Lauren-Dayanna-Villanueva-Camero/Parcial2Parqueadero.git

### 2. Crear la base de datos
CREATE DATABASE Parcial2Parqueadero;


### 3. Configurar application.properties
- spring.datasource.username= [tu usuario]
- spring.datasource.password=[tu contraseña]


### 4. Compilar y ejecutar
- mvn clean install
- mvn spring-boot:run

La aplicación estará disponible en: http://localhost:8080

### Credenciales de Prueba
- ROL: Administrador, USUARIO: admin@parqueadero.com,	CONTRASEÑA:1234
- ROL: Acomodador USUARIO: acomodador@parqueadero.com,	CONTRASEÑA:1234
- ROL: Cliente, USUARIO: cliente@parqueadero.com, CONTRASEÑA:1234

### Documentación API
- La documentación de la API REST está disponible en Swagger UI:
http://localhost:8080/swagger-ui.html

### Funcionalidades
**ADMINISTRADOR**:
- Crear registros de vehículos
- Editar registros existentes
- Eliminar registros
- Visualizar todos los registros
- Gestionar tipos de vehículo
- Gestionar clientes

  **ACOMODADOR**
- Visualizar todos los registros
- Actualizar ubicaciones de vehículos
- Registrar salida de vehículos

  **CLIENTE**
- Visualizar registros (solo lectura)
  
### Autor
Lauren Dayanna Villanueva Camero

Código: 20241220012

Email: u20241220012@usco.edu.co

Universidad Surcolombiana
