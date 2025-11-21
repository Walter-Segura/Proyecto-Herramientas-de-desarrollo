# Etapa 1: Construcción del proyecto con Maven
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
RUN mvn -q dependency:go-offline

COPY src ./src

# Compilar y empaquetar
RUN mvn -q clean package -DskipTests

# Etapa 2: Imagen final para producción
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
