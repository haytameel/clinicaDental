# ---------- Stage 1: build ----------
FROM eclipse-temurin:19-jdk-alpine AS build

# Instalar dependencias necesarias
RUN apk add --no-cache maven

# Crear directorio de trabajo
WORKDIR /app

# Copiar pom.xml y descargar dependencias (cache eficiente)
COPY backend/pom.xml backend/mvnw backend/.mvn/ ./backend/
WORKDIR /app/backend
RUN ./mvnw dependency:go-offline

# Copiar el resto del proyecto y compilar
COPY backend/ /app/backend/
RUN ./mvnw clean package -DskipTests

# ---------- Stage 2: runtime ----------
FROM eclipse-temurin:19-jdk-alpine

WORKDIR /app

# Copiar el JAR construido desde la etapa de build
COPY --from=build /app/backend/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
