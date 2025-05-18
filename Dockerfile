# Imagen base oficial de Java 21
FROM eclipse-temurin:21-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven
COPY target/ubicacion-api-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto (ajusta si tu backend usa otro)
EXPOSE 8080

# Comando para ejecutar el JAR
CMD ["java", "-jar", "app.jar"]
