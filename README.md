## Estructura del Proyecto

El proyecto sigue la arquitectura MVC, esta sobre la plantilla de las clases de software, entonces lo separé los html por una carpeta.

```
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
```

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

* **Java JDK 11** o superior.
* **Maven** instalado y configurado en las variables de entorno de tu sistema.
* **PostgreSQL Server** instalado y el servicio en ejecución.

## Instalación y Ejecución

Sigue estos pasos para poner en marcha el proyecto en tu entorno local.

#### 1. Clonamos el Repositorio
Abre una terminal (PowerShell, Git Bash, etc.) y clona el proyecto.

```bash
git clone linkdeesterepositorio
cd <NOMBRE_DEL_PROYECTO>
```

#### 2. Configuramos la Base de Datos
Es crucial preparar la base de datos antes de ejecutar la aplicación.

* Abre el gestor de base de datos (ej. **pgAdmin**).
* Crea una nueva base de datos con el nombre **`productos_db`**.
* Conéctate a `productos_db` y ejecuta el script completo del archivo **`db.sql`**. Esto creará la tabla `usuarios` y los datos iniciales.
* Verifica que las credenciales en `src/main/resources/application.properties` coincidan con tu configuración de PostgreSQL.

#### 3. Ejecutamos la Aplicación
Una vez configurada la base de datos, puedes iniciar la aplicación desde tu IDE (como IntelliJ IDEA) o usando Maven en la terminal.

```bash
mvn spring-boot:run
```

Verás en la consola que el servidor Tomcat se ha iniciado en el puerto `9000`.

#### 4. Acceder a la Aplicación
Abre tu navegador web y ve a la siguiente URL:

**`http://localhost:9000`**


* **Email:** `admin@abc.com`
* **Contraseña:** `admin123`
