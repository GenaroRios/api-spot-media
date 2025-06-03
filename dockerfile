# Imagen base liviana con Java 17 (podés cambiar la versión si usás otra)
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/spot-media-0.0.1-SNAPSHOT.jar spot-media.jar

ENTRYPOINT ["java", "-jar", "spot-media.jar"]