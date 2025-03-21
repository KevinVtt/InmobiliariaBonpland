# Proyecto Inmobiliario Bondpland

Este proyecto es una aplicación web desarrollada con Spring Boot para la gestión de inmuebles. A continuación, se detallan los pasos necesarios para configurar y ejecutar el proyecto en tu entorno local.

---

## Requisitos Previos

- **JDK +17**: Asegúrate de tener instalado el JDK (Java Development Kit) versión 17 o superior.
- **VS Code**: El editor de código que utilizaremos para este proyecto.

---

## Instalación

### 1. Instalar JDK +17

Descarga e instala el JDK desde [aquí](https://www.oracle.com/java/technologies/javase-downloads.html).

### 2. Instalar Extensiones de VS Code

Abre VS Code y instala las siguientes extensiones:

- [Spring Initializr](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-initializr)
- [Spring Boot Tools](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-spring-boot)
- [Spring Boot Dashboard](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-spring-boot-dashboard)
- [Spring Boot Dev Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

### 3. Clonar el Repositorio

Clona el repositorio utilizando el siguiente comando:

git clone <https://github.com/KevinVtt/InmobiliariaBonpland.git>


### 4. Configraucion de la base de datos

1. Configurar application.properties
Abre el archivo application.properties y configura las siguientes propiedades:

spring.datasource.username=<TU_USUARIO_DE_MYSQL>
spring.datasource.password=<TU_CONTRASEÑA_DE_MYSQL>
spring.jpa.hibernate.ddl-auto=update

Nota: Inicialmente, establece spring.jpa.hibernate.ddl-auto en create para crear las tablas en la base de datos. Una vez creadas, cámbialo a update.

### 5. Ejecutar la Aplicación

1. Usar Spring Boot Dashboard
Abre el Spring Boot Dashboard en VS Code y en la sección de "Apps", ejecuta la aplicación.

2. Acceder a la Aplicación
Una vez que la aplicación esté en ejecución, puedes acceder a ella desde tu navegador en: http://localhost:8080

### 6. Rutas Disponibles
Panel Privado: http://localhost:8080/gestion/inmobiliaria

Este es el panel privado para la gestión de inmuebles. Aquí puedes crear, eliminar, editar y ver los inmuebles. Actualmente, este panel no tiene un sistema de autenticación, por lo que se recomienda implementar un sistema de login en el futuro.