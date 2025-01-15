# Usar una imagen base con Java 21
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado al contenedor
COPY target/machine_management_ms.jar app.jar

# Exponer el puerto en el que la app escucha
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
