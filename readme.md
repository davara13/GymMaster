

# Machine Management MS

Aplicación CRUD MS basada en Java para gestionar ejercicios y rutinas. Utiliza MySQL como base de datos. La aplicación expone puntos finales de API RESTful para gestionar máquinas.

## Tecnologías Utilizadas

* Java: 21
* Framework: Spring Boot 3.4.1
* Base de Datos: MySQL (hosteada en Clever Cloud)
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


## Configuración del Proyecto

1. **Clonar el repositorio:**

```bash
git clone https://github.com/tu-usuario/machine-management-ms.git
cd machine-management-ms
```

2. **Configurar el archivo de propiedades:**
Si planeas usar una base de datos local o diferente, ajusta las siguientes propiedades en `src/main/resources/application.properties`:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```
se requiere tener la base de datos creada previamente

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



