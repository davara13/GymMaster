Para ejecutar el micro servicio en docker,
 ejecute los siguientes comandos ubicado dentro de la carpeta raiz del proyecto:

1. docker build -t machine-management .
2. docker run -p 8081:8080 --name machine-management-container machine-management

