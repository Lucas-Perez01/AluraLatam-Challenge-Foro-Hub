Foro Hub - Challenge Alura

Foro Hub es una aplicación backend construida con Spring Boot que permite gestionar usuarios, autenticación JWT y CRUD de tópicos en un foro educativo. Este proyecto fue desarrollado como parte de un challenge de Alura.

Tecnologías

Java 17

Spring Boot

Spring Security

Spring Data JPA

JWT (JSON Web Token)

MySQL

Lombok

Maven

Funcionalidades
Autenticación

Registro y login de usuarios.

Autenticación mediante JWT.

Seguridad de endpoints con roles.

Gestión de Tópicos

Crear, listar, actualizar y eliminar tópicos.

Paginación y ordenamiento de tópicos.

Control de estado de los tópicos (ACTIVO, INACTIVO).

Endpoints principales
Método	Endpoint	Descripción
POST	/auth	Iniciar sesión y obtener token JWT
GET	/prueba	Endpoint de prueba
POST	/topicos	Crear un nuevo tópico
GET	/topicos	Listar tópicos (paginado y ordenado)
GET	/topicos/{id}	Obtener detalle de un tópico
PUT	/topicos/{id}	Actualizar un tópico
DELETE	/topicos/{id}	Eliminar un tópico

Estructura del proyecto
src
└── main
├── java
│   └── Alura.Challenge.Foro_Hub
│       ├── ChallengeForoHubApplication.java
│       ├── controller
│       │   ├── AuthController.java
│       │   ├── PruebaController.java
│       │   └── TopicoController.java
│       ├── domain
│       │   ├── security
│       │   │   ├── DatosDelTokenJWT.java
│       │   │   ├── SecurityConfiguration.java
│       │   │   ├── SecurityFilter.java
│       │   │   └── TokenService.java
│       │   ├── topico
│       │   │   ├── Topico.java
│       │   │   ├── TopicoRepository.java
│       │   │   ├── DatosRegistroTopico.java
│       │   │   ├── DatosActualizacionTopico.java
│       │   │   ├── DatosDetalleTopico.java
│       │   │   ├── DatosListaTopico.java
│       │   │   └── StatusTopico.java
│       │   └── usuario
│       │       ├── Usuario.java
│       │       ├── UsuarioRepository.java
│       │       ├── DatosUsuario.java
│       │       └── AuthenticationService.java
│       └── GenerarHash.java
└── resources
├── application.properties
└── db.migrations
├── V1_create_topico.sql
└── V2_create_usuarios.sql

Base de Datos

Se utiliza MySQL con dos tablas principales: topico y usuarios.

Scripts de creación:
CREATE TABLE IF NOT EXISTS topico (
id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(100) NOT NULL,
mensaje VARCHAR(255) NOT NULL,
fechaCreacion DATETIME NOT NULL,
status_topico VARCHAR(20) NOT NULL DEFAULT 'inactivo',
autor VARCHAR(50) NOT NULL,
curso VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS usuarios (
id INT UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(50) NOT NULL,
contrasenia VARCHAR(50) NOT NULL
);

Seguridad

Spring Security con JWT.

Endpoint /auth abierto para login.

Todos los demás endpoints requieren token JWT válido.

Tokens expiran cada 2 horas.

Contraseñas almacenadas con BCrypt.

Ejemplo de cómo generar un hash de contraseña:

BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
System.out.println(encoder.encode("123456"));