

# Machine Management MS

Aplicación CRUD MS basada en Java para gestionar ejercicios y rutinas. Utiliza MySQL como base de datos. La aplicación expone puntos finales de API RESTful para gestionar máquinas.

## Tecnologías Utilizadas

* Java: 21
* Framework: Spring Boot 3.4.1
* Base de Datos: MySQL
* Gestión de Dependencias: Maven
* Librerías Adicionales:
    * Lombok: Simplifica la escritura de código Java.
    * Spring Data JPA: Para operaciones con la base de datos.
    * Spring Web: Para la creación de endpoints REST

---

## Requisitos Previos

* Software necesario:
    * JDK 21
    * Maven 3.8+

* Variables de entorno:
   * SPRING_DATASOURCE_URL: URL de la base de datos.
   * SPRING_DATASOURCE_USERNAME: Usuario de la base de datos.
   * SPRING_DATASOURCE_PASSWORD: Contraseña de la base de datos.

## Configuración del Proyecto

1. **Clonar el repositorio:**

```bash
git clone https://github.com/tu-usuario/machine-management-ms.git
cd machine-management-ms
```

2. **Configurar el archivo de propiedades:**

   Se deben configurar las variables de entorno. Para esto se pueden fijar de forma local como:

* Para Windows (Command Prompt o PowerShell):
  ```bash
   set SPRING_DATASOURCE_URL= url-dabase
   set SPRING_DATASOURCE_USERNAME= username
   set SPRING_DATASOURCE_PASSWORD= password
   ```

* Para macOS o Linux (Terminal):

   ```bash
   export SPRING_DATASOURCE_URL= url-dabase
   export SPRING_DATASOURCE_USERNAME= username
   export SPRING_DATASOURCE_PASSWORD= password
   ```

* Si se desea usar un archivo `.env`:
   Crea un archivo `.env` en el directorio raíz del proyecto:

   ```env
   SPRING_DATASOURCE_URL=url-database
   SPRING_DATASOURCE_USERNAME= username
   SPRING_DATASOURCE_PASSWORD= password
   ```

   Para ejecutar la app en local, cargando las variables de entorno desde el archivo `.env` se puede ejecutar:
   * Para Windows (Command Prompt o PowerShell):
     ```bash
      setlocal enabledelayedexpansion
      for /f "delims=" %%x in (.env) do set %%x
     ```
     Se verifica su carga con:
     ```bash
      echo $env:NOMBRE_DE_LA_VARIABLE
     ```
   *  Para macOS o Linux (Terminal):
        ```bash
         set -a
         source .env
         set +a
         ```
      Se verifica su carga con:
         ```bash
         echo %NOMBRE_DE_LA_VARIABLE%
        ```
   *  Si se desea se pueden configurar las variables directamente en `src/main/resources/application.properties`:
     Se requiere tener la base de datos creada previamente
      ```bash
      spring.datasource.url=jdbc:mysql:url-database
      spring.datasource.username=username
      spring.datasource.password=password
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Compilar el proyecto:**

Ubicado en la carpeta raiz se debe ejecutar

```bash
./mvnm clean install
```

4. **Ejecutar el microservicio:**
```bash
mvn spring-boot:run
```

Por defecto, la aplicacion se ejecuta en `http://localhost:8080`.


## Endpoints REST Disponibles
### Base URL:  `/api/machines`

### Máquinas
| Metodo | Endpoint       | Descripción                |
|--------|----------------|----------------------------|
| POST   | `/`  | Crear una nueva máquina.     |
| GET    | `/{id}`  | Obtener los detalles de una máquina por su ID.|
| GET    | `/` | Listar todas las máquinas. |
| PUT    | `/{id}` | Actualizar una máquina existente por su ID.  |
| DELETE | `/{id}` |  Eliminar una máquina por su ID.  |

### Servicios de maquina (mantenimientos)
| Metodo | Endpoint       | Descripción                |
|--------|----------------|----------------------------|
| POST   | `/{machineId}/services`  | Agregar un nuevo mantenimiento a una máquina.    |
| GET    | `/{machineId}/services`  | Listar los mantenimientos asociados a una máquina.|


## Ejecución con Docker (Opcional)

1. Construir la imagen 
```bash
docker build -t machine_management_ms .
```

2. Ejecutar contenedor
```bash
docker run -p 8080:8080 --env-file .env machine_management_ms
```



