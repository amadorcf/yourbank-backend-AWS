# 📌 YourBank - Microservicios con Spring Boot

## 📖 Introducción
La aplicación bancaria se ha desarrollado utilizando una arquitectura de microservicios, aprovechando el marco Spring Boot y un conjunto de tecnologías del ecosistema Spring, como Spring Data JPA, Spring Cloud y Spring Security. Para la gestión de dependencias, se utiliza Maven, que facilita la integración y administración de las bibliotecas necesarias.

Estas tecnologías permiten la creación y orquestación de componentes críticos como el Service Registry, el API Gateway, entre otros, proporcionando una infraestructura sólida para la implementación de microservicios.

Cada microservicio, como el servicio de usuario para la gestión de usuarios, el servicio de cuenta para la creación y administración de cuentas, el servicio de transferencia de fondos para operaciones financieras, y el servicio de transacciones para la consulta de movimientos y gestión de retiros y depósitos, se desarrolla de manera independiente.

Este enfoque modular no solo optimiza el desarrollo, sino que también mejora significativamente la escalabilidad y mantenibilidad de la aplicación, asegurando un sistema robusto, flexible y eficiente en términos operativos y de recursos.

---

## 🛠️ Tecnologías utilizadas
Se han utilizado las siguientes tecnologías:

- **Spring Boot**: para un desarrollo rápido y una configuración sencilla del proyecto.
- **Spring Security**: para manejar la autenticación y autorización del usuario.
- **JSON Web Tokens (JWT)**: para autenticación de usuario segura y autorización basada en token.
- **Base de datos MySQL**: para almacenar datos de usuarios y transacciones.

---

## 🏗️ Arquitectura

- **Registro de servicios**: los microservicios utilizan el servicio de descubrimiento para el registro y el descubrimiento de servicios, lo que ayuda a los microservicios a descubrir y comunicarse con otros servicios, sin necesidad de codificar los puntos finales mientras se comunican con otros microservicios.
- **API Gateway**: este microservicio utiliza la puerta de enlace API para centralizar el punto final API, donde todos los puntos finales tienen un punto de entrada común.
- **Base de datos por microservicio**: cada uno de los microservicios tiene su propia base de datos dedicada, lo que ayuda a aislar cada servicio y facilita la escalabilidad de cada base de datos cuando sea necesario.

---

## 🔹 Microservicios

### 👤 Servicio de usuario
El microservicio de usuario proporciona funcionalidades para la gestión de usuarios. Esto incluye:
- Registro del usuario.
- Actualización de los detalles del usuario.
- Visualización de la información del usuario.
- Acceso a todas las cuentas asociadas con el usuario.
- Manejo de autenticación y autorización de usuarios.

### 💼 Servicio de cuenta
El microservicio de cuenta administra las API relacionadas con la cuenta. Permite:
- Modificar los detalles de la cuenta.
- Ver todas las cuentas vinculadas al perfil del usuario.
- Acceder a los historiales de transacciones de cada cuenta.
- Soporte para el proceso de cierre de la cuenta.

### 💸 Servicio de transferencia de fondos
El microservicio de transferencia de fondos facilita funcionalidades relacionadas con la transferencia de fondos:
- Iniciar transferencias de fondos entre diferentes cuentas.
- Acceder a registros detallados de transferencias de fondos.
- Ver detalles específicos de cualquier transacción de transferencia de fondos.

### 💳 Servicio de transacciones
El servicio de transacciones ofrece una gama de servicios relacionados con transacciones:
- Ver transacciones basadas en cuentas específicas o ID de referencia de transacciones.
- Realizar depósitos o retiros de cuentas.

---

## 🚀 Instalación y ejecución
### 🔧 Requisitos previos
Asegúrate de tener instalados los siguientes componentes en tu sistema:
- JDK 15 o superior.
- Maven.
- MySQL.
- Docker (opcional para contenedores).

### 📌 Pasos para ejecutar el proyecto
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
   ```
2. Configura las bases de datos y las credenciales en `application.properties` de cada microservicio.
3. Construye y ejecuta cada microservicio con Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. Accede a la aplicación a través de la API Gateway.

---

## 📜 Licencia
Este proyecto está bajo la licencia [MIT](LICENSE).


## 📞 Contacto
Si tienes preguntas o sugerencias, puedes contactarnos en: https://amadorcf.es/contact

