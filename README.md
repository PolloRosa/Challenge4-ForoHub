# Challenge 4 Foro Hub

![Versión: 1.0](https://img.shields.io/badge/VERSIÓN-1.0-blue) ![Fecha de lanzamiento: 07/03/2026](https://img.shields.io/badge/Fecha_de_lanzamiento-07/03/2026-blue)

![Java 17](https://img.shields.io/badge/Java_17-b07219)
![Spring Boot 3.5.11](https://img.shields.io/badge/Spring_Boot_3.5.11-6db33f)
![MySQL 8.0.45](https://img.shields.io/badge/MySQL_8.0.45-0074a3)
![Maven 4](https://img.shields.io/badge/Maven_4-F79A23)

![Flyway](https://img.shields.io/badge/Flyway-c00c00)
![Lombok](https://img.shields.io/badge/Lombok-ce4844)
![Spring Security](https://img.shields.io/badge/Spring_Security-6db33f)
![JWT](https://img.shields.io/badge/JWT-191919)


## Introducción

El programa [Oracle Next Education (ONE)](https://www.oracle.com/latam/education/oracle-next-education/) es un programa de educación, inclusión y empleabilidad que forma a personas en tecnología y las conecta con el mercado laboral con el apoyo de empresas asociadas.

Es un programa gratuito que dura 12 meses. Abre inscripciones 2 veces al año donde las personas pueden postular mediante un formulario. Cada generación es enumerada con números arábigos.

El proyecto Foro Hub es el Challenge 4 del programa ONE de Oracle y Alura Latam del grupo G9 que inició en julio 2025. Es el tercer reto de desarrollo de la fase 3 (para estudiantes admitidos en el programa) y cuarto reto entre todas las fases después del aprendizaje de los cursos de Spring Boot 3 de desarrollo de un API REST, mejores prácticas, Seguridad, documentación, Testing e implementación.

El reto tiene como finalidad poner a prueba a los estudiantes en 4 puntos: programación Orientada a Objetos en Java con Spring Boot Framework, desarrollo de un API REST, conexión con MySQL, y uso de Git y GitHub.

## Descripción del proyecto

Foro Hub es un API REST para la creación, actualización, eliminación, listado y búsqueda de tópicos en un foro. Tienes a tu disposición 12 endpoints que cubren el CRUD de Tópico y 1 endpoint del inicio de sesión para obtener el token que da acceso al uso de los endpoints de Tópico.

## Estado del proyecto

El día 07 de marzo del 2026 se lanzó la versión 1 del proyecto siguiendo las indicaciones del video instructivo y tablero en Trello, ambos provistos por el programa ONE.

El proyecto se encuentra en su [versión 1.0](#registro-de-cambios).

## Demostración de funcionalidad

El proyecto tiene 7 funcionalidades programadas haciendo un total de 13 endpoints activos.

POST

1. `/login`: Inicio de sesión
2. `/topicos`: Registro de tópico

GET

1. `/topicos`: Lista de tópicos
2. `/topicos/curso/{nombreCurso}`: Consulta de tópicos por nombre de curso
3. `/topicos/anio/{anioCreacion}`: Consulta de tópicos por año de creación
4. `/topicos/curso/{nombreCurso}/anio/{anioCreacion}`: Consulta de tópicos por nombre de curso y año de creación
5. `/topicos/anio/{anioCreacion}/curso/{nombreCurso}`: Consulta de tópicos por año de creación y nombre de curso
6. `/topicos/{id}`: Consulta de tópico por id
7. `/topicos/`: Consulta de tópico por id, con validación del id como dato mandatorio

PUT

1. `/topicos/{id}`: Actualización de tópico por id
2. `/topicos/`: Actualización de tópico por id, con validación del id como dato mandatorio

DELETE

1. `/topicos/{id}`: Eliminación de tópico por id
2. `/topicos/`: Eliminación de tópico por id, con validación del id como dato mandatorio

El proyecto tiene implementada la documentación con la dependencia Springdoc, puedes verificar las especificaciones y funcionalidad de todos los endpoints en la ruta `/swagger-ui/index.html`.

## Tecnologías usadas

* JDK 17.0.13
* IntelliJ IDEA 2025.3.1
* [Spring Boot Framework 3.5.11](https://start.spring.io/)
* Dependencia spring-boot-starter-web de Maven
* Dependencia spring-boot-devtools de Maven
* Dependencia org.projectlombok de Maven
* Dependencia spring-boot-starter-data-jpa de Maven
* Dependencia spring-boot-starter-validation de Maven
* Dependencia flyway-core de Maven
* Dependencia flyway-mysql de Maven
* Dependencia mysql-connector-j de Maven
* Dependencia spring-boot-starter-security de Maven
* Dependencia java-jwt de Maven
* Dependencia springdoc-openapi-starter-webmvc-ui de Maven
* MySQL 8.0.45
* Git para control de versiones

## Estructura del proyecto

Para el proyecto se eligió usar la Estructura por Dominio.

```
src/main/java/com/pollorosa/forohub/
├── controller/
│   ├── AutenticacionController.java
│   └── TopicoController.java
├── domain/
│   ├── curso/
│   │   ├── Categoria.java
│   │   ├── Curso.java
│   │   ├── CursoRepository.java
│   │   └── DatosDetalleCurso.java
│   ├── topico/
│   │   ├── validaciones/
│   │   │   ├── ValidadorCursoExisteActivo.java
│   │   │   ├── ValidadorCursoExisteActivoParaActualizar.java
│   │   │   ├── ValidadorCursoExisteActivoParaBuscar.java
│   │   │   ├── ValidadorDeActualizacion.java
│   │   │   ├── ValidadorDeBusqueda.java
│   │   │   ├── ValidadorDeRegistro.java
│   │   │   ├── ValidadorDuplicidadTopicos.java
│   │   │   ├── ValidadorUsuarioActivo.java
│   │   │   └── ValidadorUsuarioActivoParaActualizar.java
│   │   ├── DatosDetalleTopico.java
│   │   ├── DatosListaTopico.java
│   │   ├── DatosRegistroTopico.java
│   │   ├── Respuesta.java
│   │   ├── Status.java
│   │   ├── Topico.java
│   │   ├── TopicoRepository.java
│   │   └── TopicoService.java
│   ├── usuario/
│   │   ├── AutenticacionService.java
│   │   ├── DatosAutenticacion.java
│   │   ├── DatosDetalleUsuario.java
│   │   ├── Perfil.java
│   │   ├── Usuario.java
│   │   └── UsuarioRepository.java
│   └── ValidacionException.java
├── infra/
│   ├── exceptions/
│   │   └── GestorDeExceptions.java
│   ├── security/
│   │   ├── DatosTokenJWT.java
│   │   ├── SecurityConfigurations.java
│   │   ├── SecurityFilter.java
│   │   └── TokenService.java
│   └── springdoc/
│       └── SpringDocConfiguration.java
└── ForohubApplication.java
```

## Base de Datos

Holo

## Seguridad

JWT

## Instalación local

1. Holo

## Registro de cambios

Holo

## Autor

Angela Cáceres @PolloRosa :baby_chick:

## Licencia

El proyecto está bajo la licencia MIT. Puedes usarlo, compartirlo y modificarlo libremente, incluso con fines comerciales. La única condición es que conserves el aviso de derechos de autor original y el texto de la licencia en todas las copias o partes sustanciales del software.

Eres bienvenido/a de forkearlo y enviar tu PR.