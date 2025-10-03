# Lab 3 de software
# Estructura de mi proyecto
java-mvc-productos/
│
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/demo/productos/
│   │   │       ├── controller/
│   │   │       │   └── UsuarioController.java
│   │   │       ├── model/
│   │   │       │   └── Usuario.java
│   │   │       ├── repository/
│   │   │       │   └── UsuarioRepository.java
│   │   │       ├── service/
│   │   │       │   ├── UsuarioService.java
│   │   │       │   └── UsuarioServiceImpl.java
│   │   │       └── MvcProductosApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       │   └── laboTres/
│   │       │       ├── login.html
│   │       │       ├── listar-usuarios.html
│   │       │       ├── crear-usuario.html
│   │       │       └── editar-usuario.html
│   │       └── application.properties
│   │
│   └── test/
│
├── db.sql                      # Script para crear y poblar la base de datos
├── pom.xml                     # Dependencias y configuración de Maven
└── README.md                   # Este archivo

# Listado de pasos
1. Requisitos Previos
Java JDK 11 o superior instalado.

Apache Maven instalado y configurado en el PATH del sistema.

PostgreSQL Server instalado y ejecutándose.

2. Pasos para Instalar y Ejecutar la Aplicación
Abrimos PowerShell o una terminal de tu preferencia
1. Clonamos el repositorio en la carpeta que elijamos
git clone <URL_DE_TU_REPOSITORIO_EN_GITHUB>
cd <NOMBRE_DEL_PROYECTO>

2. Configuramos la base de datos
- Abre pgAdmin y crea una nueva base de datos llamada "productos_db".
- Conéctate a "productos_db" y ejecuta el script del archivo db.sql para crear la tabla y los datos.
- Revisa y ajusta las credenciales en 'src/main/resources/application.properties' si es necesario.
3. Compilamos y ejecutamos el intellJidea, debemos ver el tomcat con el puerto en la terminal y nos vamos a google

4. Abrimos el google
La aplicación estará disponible en http://localhost:9000
3. Credenciales para Iniciar Sesión
Para acceder al panel de administración, utiliza las siguientes credenciales que fueron creadas por el script db.sql:

Email: admin@abc.com

Contraseña: admin123
